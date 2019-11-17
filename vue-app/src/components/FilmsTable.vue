<template>
  <div id="films-table">
    <table class="table">
      <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">Name</th>
        <th scope="col">Description</th>
      </tr>
      </thead>
      <tbody>
      <tr v-for="f in films" :key="f.filmId">
        <td>{{f.filmId}}</td>
        <td>{{f.title}}</td>
        <td class="text-md-left">{{f.description}}</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
    export default {
        name: "films-table",
        props: {
            films: Array
        }
    };
</script>

<style scoped></style>