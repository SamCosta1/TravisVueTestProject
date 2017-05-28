import Vue from 'vue'
import App from './App.vue'
import ChatHead from './components/ChatHead.vue'

Vue.component("chat-head", ChatHead);

new Vue({
  el: '#app',
  render: h => h(App)
})
