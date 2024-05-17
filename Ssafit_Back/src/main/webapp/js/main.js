function changeSource(id){
    $("#myIFrame").attr("src", id.value);
}


$('#exampleModalCenter').on('shown.bs.modal', function () {
    $('#myInput').trigger('focus')
  })


  $(document).ready(function(){
    $.getJSON("./video.json", function(data){
        for (let i = 0; i < data.length; i++){
        console.log(data[i]);
        create_card(data[i], i);
        }
    }).fail(function(){
        console.log("An error has occurred.");
    });
    
});

$(document).ready(changePart());

function create_card(videoInfo, i){
    let tagArea = document.getElementById('videoArea');
    let newCard = document.createElement('div');
    // 엘레먼트를 만들고
    // getElebyid
    // 걔의 value 값을 바꾼다.
    newCard.setAttribute('class', 'card');
    newCard.innerHTML = `<input type = "hidden" value="${videoInfo.url}"  id = "trend_` +i+ `"><input type="hidden" value="${videoInfo.id}" videoid="${videoInfo.videoid}"><img class="card-img-top" src=http://img.youtube.com/vi/${videoInfo.id}/0.jpg alt="Card image cap" data-bs-toggle="modal" data-bs-target="#exampleModalCenter" onClick = changeSource(trend_` +i+ `);></button><div class="card-body"><p class="card-text">${videoInfo.title}</p></div>`
    
    tagArea.appendChild(newCard);

  }


function changePart() {
    var x = document.getElementById("mySelect").value;
    console.log(x);
    let tagArea = document.getElementById('videoArea2');
    while (tagArea.firstChild) {
        tagArea.firstChild.remove()
    }
    $.getJSON("./video.json", function(data){
        for (let i = 0; i < data.length; i++){  
            if (data[i].part == x){
                console.log(data[i]);
                create_card2(data[i], i);
            }
        }
    }).fail(function(){
        console.log("An error has occurred.");
    });
    
};



function create_card2(videoInfo, i){
    let tagArea = document.getElementById('videoArea2');
    let newCard = document.createElement('div');
    
    newCard.setAttribute('class', 'card');
    newCard.innerHTML = `<input type = "hidden" value="${videoInfo.url}"  id = "part_` +i+ `"><img class="card-img-top" src=http://img.youtube.com/vi/${videoInfo.id}/0.jpg alt="Card image cap" data-bs-toggle="modal" data-bs-target="#exampleModalCenter" onClick = changeSource(part_` +i+ `);></button><div class="card-body"><p class="card-text">${videoInfo.title}</p></div>`
    
    tagArea.appendChild(newCard);

  }
