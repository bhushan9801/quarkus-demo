<template>
  <div id="films-app">
    <b-navbar>
      <template slot="brand">
        <b-navbar-item tag="router-link" :to="{ path: '/' }">
          <img
            src="https://raw.githubusercontent.com/buefy/buefy/dev/static/img/buefy-logo.png"
            alt="Lightweight UI components for Vue.js based on Bulma"
          >
        </b-navbar-item>
      </template>
      <template slot="start">
        <b-navbar-item href="/">
          Home
        </b-navbar-item>
        <b-navbar-item href="/films">
          Films
        </b-navbar-item>
        <b-navbar-item href="/actors">
          Actors
        </b-navbar-item>
      </template>
    </b-navbar>
    <div class="container">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
    export default {
        name: "films-app",
    };
</script>

<style>
  #app {
    font-family: "Avenir", Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
  }
</style>
