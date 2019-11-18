<template>
  <div id="films-table">
    <b-table bordered hover :items="films" :fields="fields"></b-table>
  </div>
</template>

<script>
    import {RepositoryFactory} from '../repository/RepositoryFactory'

    const FilmsRepository = RepositoryFactory.get('films');

    export default {
        name: "films-table",
        data() {
            return {
                films: [],
                fields: []
            };
        },
        created() {
            this.getFilms();
        },
        methods: {
            async getFilms() {
                try {
                    const {data} = await FilmsRepository.get();
                    this.films = data;
                    this.fields = ["filmId", "title", "description"];
                } catch (error) {
                    console.log(error);
                }
            }
        }
    };
</script>

<style scoped></style>