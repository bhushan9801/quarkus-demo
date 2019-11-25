import Repository from './Repository';

const resource = "/films";

export default {
  list(page = 1, size = 20) {
    return Repository.get(`${resource}`, {params: {"order": "+filmId", "page": page, "size": size}})
  },
  get(id) {
    return Repository.get(`${resource}/${id}`)
  },
  sample(id) {
    Repository.get(`${resource}/${id}`).then(function (response) {
      // handle success
      console.log(response.data);
    })
      .catch(function (error) {
        // handle error
        console.log(error);
      })

  }
}
