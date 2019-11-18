import Repository from './Repository';

const resource = "/films";

export default {
  get() {
    return Repository.get(`${resource}`, {params: {"order": "+filmId"}})
  }
}