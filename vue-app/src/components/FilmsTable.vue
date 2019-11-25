<template>
  <div id="films-table" class="overflow-auto">
    <b-pagination :total="total" :per-page="page.size" aria-next-label="Next page" aria-previous-label="Previous page"
      aria-page-label="Page" :current.sync="page.pageNumber" aria-current-label="Current page" @change="getFilms"
    :range-before="2" :range-after="2"></b-pagination>
    <!--    <b-pagination v-model="page.pageNumber" :total-rows="total" :per-page="page.size" aria-controls="film-table"-->
    <!--                  @input="getFilms(page.pageNumber)"></b-pagination>-->

    <b-table id="film-table" bordered hover :data="films" :columns="fields">
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
                    const {data} = await FilmsRepository.list(pageNumber);
                    this.films = data.data;
                    this.page = data.page;
                    this.total = data.total;
                    this.fields = [{
                        "field": "filmId",
                        "label": "ID"
                    }, {"field": "title", "label": "Movie Title"}, {
                        "field": "description",
                        "label": "Summary"
                    }, {"field": "languageName", "label": "Language"}];
                } catch (error) {
                    console.log(error);
                }
            }
        }
    };
</script>

<style scoped></style>
