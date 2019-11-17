<template>
  <div id="app" class="container">
    <img alt="Vue logo" src="./assets/logo.png" />
    <films-table v-bind:films="films"></films-table>
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'
import FilmsTable from "./components/FilmsTable.vue";

export default {
  name: "app",
  components: {
    FilmsTable
  },
  data() {
    return {
      employees: [
        {
          id: 1,
          name: "Richard Hendricks",
          email: "richard@piedpiper.com"
        },
        {
          id: 2,
          name: "Bertram Gilfoyle",
          email: "gilfoyle@piedpiper.com"
        },
        {
          id: 3,
          name: "Dinesh Chugtai",
          email: "dinesh@piedpiper.com"
        }
      ],
      films: []
    };
  },
  methods: {
    async getFilms() {
      try {
        const films = await fetch("http://localhost:8080/api/films?order=filmId", {
          method: "GET",
          headers: {
            "Content-Type": "application/json",
            Accept: "application/json"
          }
        });
        const data = await films.json();
        this.films = data;
      } catch (error) {
        console.log(error);
      }
    }
  },
  mounted() {
    console.log("mounted called");
    this.getFilms();
  }
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
