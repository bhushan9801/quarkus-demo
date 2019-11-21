<template>
  <div id="films-table" class="overflow-auto">
    <b-pagination v-model="page.pageNumber" :total-rows="total" :per-page="page.size" aria-controls="film-table"
                  @input="getFilms(page.pageNumber)"></b-pagination>

    <b-table tbody-tr-class="text-md-left" id="film-table" bordered hover :items="films" :fields="fields">
      <template v-slot:cell(filmId)="data">
        <router-link :to="`/films/${data.value}`">{{data.value}}</router-link>
      </template>
    </b-table>
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
                fields: [],
                page: {},
                total: 0
            };
        },
        created() {
            this.getFilms();
        },
        methods: {
            async getFilms(pageNumber = 1) {
                try {
                    const {data} = await FilmsRepository.get(pageNumber);
                    this.films = data.data;
                    this.page = data.page;
                    this.total = data.total;
                    this.fields = ["filmId", "title", "description", "languageName"];
                } catch (error) {
                    console.log(error);
                }
            }
        }
    };
</script>

<style scoped></style>
