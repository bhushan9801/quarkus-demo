import Repository from './Repository';

const resource = "/films";

export default {
  get(page = 1, size = 20) {
    return Repository.get(`${resource}`, {params: {"order": "+filmId", "page": page, "size": size}})
  }
}