import '@babel/polyfill'
import 'mutationobserver-shim'
import Vue from 'vue'
import './plugins/bootstrap-vue'
import App from './App.vue'
import FilmsTable from "./components/FilmsTable";
import HelloWorld from "./components/HelloWorld";
import VueRouter from "vue-router";

Vue.config.productionTip = false;

Vue.use(VueRouter)

const routes = [
  {path: '/films', component: FilmsTable},
  {path: '/hello', component: HelloWorld}
];

const router = new VueRouter({
  mode: 'history',
  routes // short for `routes: routes`
});


new Vue({
  router,
  render: h => h(App),
}).$mount('#app');
