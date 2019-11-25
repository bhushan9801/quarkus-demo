<template>
  <div>
    <p>Showing film {{film.filmId}}!!!</p>
    <p>Name: {{film.title}}</p>
  </div>
</template>

<script>

    import FilmsRepository from "../repository/FilmsRepository";

    export default {
        name: "FilmsView",
        data() {
            return {
                film: {}
            };
        },
        mounted: function () {
            const filmId = this.$route.params.id;
            FilmsRepository.get(filmId).then(response => {
                this.film = response.data
            }).catch(function (error) {
                console.log("Got error: " + error)
            });
        }
    }
</script>

<style scoped>

</style>
