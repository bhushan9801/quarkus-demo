import FilmsRepository from "./FilmsRepository";


const repositories = {
  films: FilmsRepository
};

export const RepositoryFactory = {
  get: name => repositories[name]
};