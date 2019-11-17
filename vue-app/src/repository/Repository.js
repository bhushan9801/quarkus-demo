import axios from "axios"

const baseUrl = "http://localhost:8080/api";

export default axios.create({
  baseURL: baseUrl,
  headers: {
    "Content-Type": "application/json",
    "Accept": "application/json"
  }
});