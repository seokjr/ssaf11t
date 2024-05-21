<template>
  <div class="container">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div id="map"></div>
        <button @click="initMap" class="btn btn-outline-primary">내위치</button>
      </div>
    </div>
    <div id="menu_wrap" class="bg_white">
      <div class="option">
        <div>
          <form @submit.prevent="searchPlaces">
            키워드 :
            <input type="text" v-model="keyword" id="keyword" size="15" />
            <button type="submit">검색하기</button>
          </form>
        </div>
      </div>
      <hr />
      <ol id="placesList"></ol>
      <div
        id="pagination"
        aria-label="Page navigation"
        class="pagination d-flex justify-content-center"
      ></div>
    </div>
  </div>
</template>

<script setup>
import { onMounted, ref } from "vue";

let map = null;
let ps = null;
let infowindow = null;
let markers = [];

const keyword = ref("헬스장");

const initMap = () => {
  let myCenter = new kakao.maps.LatLng(33.450701, 126.570667); // 카카오본사
  if (navigator.geolocation) {
    navigator.geolocation.getCurrentPosition((position) => {
      const lat = position.coords.latitude;
      const lon = position.coords.longitude;
      myCenter = new kakao.maps.LatLng(lat, lon);
      new kakao.maps.Marker({
        map,
        position: myCenter,
      });
      map.setCenter(myCenter);
    });
  }

  const container = document.getElementById("map");
  const options = {
    center: myCenter,
    level: 3,
  };
  map = new kakao.maps.Map(container, options);

  const mapTypeControl = new kakao.maps.MapTypeControl();
  map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

  const zoomControl = new kakao.maps.ZoomControl();
  map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);

  ps = new kakao.maps.services.Places();
  infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });

  searchPlaces();
};

const searchPlaces = () => {
  if (!keyword.value.trim()) {
    alert("키워드를 입력해주세요!");
    return;
  }

  ps.keywordSearch(keyword.value, placesSearchCB);
};

const placesSearchCB = (data, status, pagination) => {
  if (status === kakao.maps.services.Status.OK) {
    displayPlaces(data);
    displayPagination(pagination);
  } else if (status === kakao.maps.services.Status.ZERO_RESULT) {
    alert("검색 결과가 존재하지 않습니다.");
  } else if (status === kakao.maps.services.Status.ERROR) {
    alert("검색 결과 중 오류가 발생했습니다.");
  }
};

const displayPlaces = (places) => {
  const listEl = document.getElementById("placesList");
  const menuEl = document.getElementById("menu_wrap");
  const fragment = document.createDocumentFragment();
  const bounds = new kakao.maps.LatLngBounds();

  removeAllChildNods(listEl);
  removeMarker();

  places.forEach((place, index) => {
    const placePosition = new kakao.maps.LatLng(place.y, place.x);
    const marker = addMarker(placePosition, index);
    const itemEl = getListItem(index, place);

    bounds.extend(placePosition);

    kakao.maps.event.addListener(marker, "mouseover", () => {
      displayInfowindow(marker, place.place_name);
    });

    kakao.maps.event.addListener(marker, "mouseout", () => {
      infowindow.close();
    });

    itemEl.onmouseover = () => {
      displayInfowindow(marker, place.place_name);
    };

    itemEl.onmouseout = () => {
      infowindow.close();
    };

    fragment.appendChild(itemEl);
  });

  listEl.appendChild(fragment);
  menuEl.scrollTop = 0;
  map.setBounds(bounds);
};

const getListItem = (index, place) => {
  const el = document.createElement("li");
  let itemStr = `<span class="markerbg marker_${index + 1}"></span>
                 <div class="info">
                   <h5>${place.place_name}</h5>`;
  if (place.road_address_name) {
    itemStr += `<span>${place.road_address_name}</span>
                <span class="jibun gray">${place.address_name}</span>`;
  } else {
    itemStr += `<span>${place.address_name}</span>`;
  }
  itemStr += `<span class="tel">${place.phone}</span></div>`;

  el.innerHTML = itemStr;
  el.className = "item";
  return el;
};

const addMarker = (position, idx) => {
  const imageSrc =
    "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png";
  const imageSize = new kakao.maps.Size(36, 37);
  const imgOptions = {
    spriteSize: new kakao.maps.Size(36, 691),
    spriteOrigin: new kakao.maps.Point(0, idx * 46 + 10),
    offset: new kakao.maps.Point(13, 37),
  };
  const markerImage = new kakao.maps.MarkerImage(
    imageSrc,
    imageSize,
    imgOptions
  );
  const marker = new kakao.maps.Marker({
    position,
    image: markerImage,
  });

  marker.setMap(map);
  markers.push(marker);
  return marker;
};

const removeMarker = () => {
  markers.forEach((marker) => marker.setMap(null));
  markers = [];
};

const displayPagination = (pagination) => {
  const paginationEl = document.getElementById("pagination");
  const fragment = document.createDocumentFragment();

  while (paginationEl.hasChildNodes()) {
    paginationEl.removeChild(paginationEl.lastChild);
  }

  for (let i = 1; i <= pagination.last; i++) {
    const el = document.createElement("a");

    el.className = "page-link";
    el.href = "#";
    el.innerHTML = i;

    if (i === pagination.current) {
      el.className = "on page-link";
    } else {
      el.onclick = (function (i) {
        return function () {
          pagination.gotoPage(i);
        };
      })(i);
    }

    fragment.appendChild(el);
  }
  paginationEl.appendChild(fragment);
};

const displayInfowindow = (marker, title) => {
  const content = `<div style="padding:5px;z-index:1;">${title}</div>`;
  infowindow.setContent(content);
  infowindow.open(map, marker);
};

const removeAllChildNods = (el) => {
  while (el.hasChildNodes()) {
    el.removeChild(el.lastChild);
  }
};

onMounted(() => {
  if (window.kakao && window.kakao.maps) {
    initMap();
  } else {
    const script = document.createElement("script");
    script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${
      import.meta.env.VITE_KAKAO_API_KEY
    }&libraries=services`;
    script.addEventListener("load", () => {
      kakao.maps.load(initMap);
    });
    document.head.appendChild(script);
  }
});
</script>

<style scoped>
#map {
  width: 100%;
  height: 600px;
  margin-bottom: 10px;
}
#menu_wrap {
  position: absolute;
  top: 0;
  left: 0;
  bottom: 0;
  width: 250px;
  margin: 10px 0 30px 10px;
  padding: 5px;
  overflow-y: auto;
  background: rgba(255, 255, 255, 0.7);
  z-index: 1;
  font-size: 12px;
  border-radius: 10px;
}
.bg_white {
  background: #fff;
}
#menu_wrap hr {
  display: block;
  height: 1px;
  border: 0;
  border-top: 2px solid #5f5f5f;
  margin: 3px 0;
}
#menu_wrap .option {
  text-align: center;
}
#menu_wrap .option p {
  margin: 10px 0;
}
#menu_wrap .option button {
  margin-left: 5px;
}
#placesList li {
  list-style: none;
}
#placesList .item {
  position: relative;
  border-bottom: 1px solid #888;
  overflow: hidden;
  cursor: pointer;
  min-height: 65px;
}
#placesList .item span {
  display: block;
  margin-top: 4px;
}
#placesList .item h5,
#placesList .item .info {
  text-overflow: ellipsis;
  overflow: hidden;
  white-space: nowrap;
}
#placesList .item .info {
  padding: 10px 0 10px 55px;
}
#placesList .info .gray {
  color: #8a8a8a;
}
#placesList .info .jibun {
  padding-left: 26px;
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/places_jibun.png)
    no-repeat;
}
#placesList .info .tel {
  color: #009900;
}
#placesList .item .markerbg {
  float: left;
  position: absolute;
  width: 36px;
  height: 37px;
  margin: 10px 0 0 10px;
  background: url(https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png)
    no-repeat;
}
#pagination {
  margin: 10px auto;
  text-align: center;
}
#pagination a {
  display: inline-block;
  margin-right: 10px;
}
#pagination .on {
  font-weight: bold;
  cursor: default;
  color: #777;
}
</style>
