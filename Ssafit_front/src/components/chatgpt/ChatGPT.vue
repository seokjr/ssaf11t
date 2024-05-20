<template>
    <div>
      <h3>운동 루틴 추천</h3>
      <textarea v-model="userInput" placeholder="당신이 원하는 운동 부위를 입력하세요" rows="5" @keyup.enter="getChatGptResponse"></textarea>
      <button @click="getChatGptExerciseResponse" class="btn btn-outline-primary">운동 추천 받기</button>
      <button @click="getChatGptRoutineResponse" class="btn btn-outline-info">루틴 추천 받기</button>
      <br>
      <div v-if="loading" class="loading-indicator">
        <div class="progress">
            <div
            class="progress-bar progress-bar-striped progress-bar-animated"
            role="progressbar"
            aria-valuemin="0"
            aria-valuemax="100"
            :style="{ width: '100%' }"
            ></div>
        </div>
      </div>
      <br>
      <div v-if="response">
        <h4>추천 결과</h4>
        <p>{{ response }}</p>
      </div>
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue'
  import axios from 'axios'
  
  const userInput = ref('')
  const response = ref('')

  const loading = ref(false);

  const setLoading = (status) => {
    loading.value = status;
  };
  
  const getChatGptExerciseResponse = async () => {
    setLoading(true);
    try {
      const payload = {
        model: "gpt-3.5-turbo",
        messages: [
          { role: "system", content: "당신은 나의 전담 헬스 트레이너입니다. 한국어로 설명해주세요" },
          { role: "user", content: `내가 입력한 부위에 대해서 할 수 있는 운동을 추천 해줘. ${userInput.value}` }
        ]
      };
  
      const res = await axios.post('https://api.openai.com/v1/chat/completions', payload, {
        headers: {
          'Authorization': `Bearer ${import.meta.env.VITE_OPENAI_API_KEY}`,
          'Content-Type': 'application/json'
        }
      });
      response.value = res.data.choices[0].message.content;
    } catch (error) {
      console.error('Error making API request:', error.response ? error.response.data : error.message);
    } finally{
        setLoading(false);
    }
  };

  const getChatGptRoutineResponse = async () => {
    setLoading(true);
    try {
      const payload = {
        model: "gpt-3.5-turbo",
        messages: [
          { role: "system", content: "당신은 나의 전담 헬스 트레이너입니다. 한국어로 설명해주세요" },
          { role: "user", content: `내가 입력한 부위에 대해서 운동 루틴을 세트 수, 반복 횟수, 쉬는 시간 등 구체적으로 추천해줘. ${userInput.value}` }
        ]
      };
  
      const res = await axios.post('https://api.openai.com/v1/chat/completions', payload, {
        headers: {
          'Authorization': `Bearer ${import.meta.env.VITE_OPENAI_API_KEY}`,
          'Content-Type': 'application/json'
        }
      });
      response.value = res.data.choices[0].message.content;
    } catch (error) {
      console.error('Error making API request:', error.response ? error.response.data : error.message);
    } finally{
        setLoading(false);
    }
  };
  </script>
  
  <style scoped>
  textarea {
    width: 100%;
    margin-top: 10px;
    margin-bottom: 10px;
  }
  
  button {
    margin-bottom: 10px;
  }
  .loading-indicator {
  text-align: center;
  margin-top: 20px;
    }

    .progress {
     height: 20px;
    }

  </style>
  