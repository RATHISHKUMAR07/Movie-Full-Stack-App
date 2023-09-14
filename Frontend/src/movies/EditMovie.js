import axios from "axios";
import React, { useEffect, useState } from "react";
import { Link, useNavigate, useParams } from "react-router-dom";
import '../form.css';
export default function EditMovie() {
  let navigate = useNavigate();

  const { id } = useParams();

  const [movie, setMovie] = useState({
        name: "",
        imdb: "",
        director: "",
        genre: "",
  });

  const { name, imdb, director, genre } = movie;

  const onInputChange = (e) => {
    setMovie({ ...movie, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    loadUser();
  }, []);

  const onSubmit = async (e) => {

    const movieData = {
      ...movie,
      imdb: parseFloat(imdb)
  };
    e.preventDefault();
    await axios.put(`http://localhost:8080/movies/${id}`, movieData);
    navigate("/");
  };

  const loadUser = async () => {
    const result = await axios.get(`http://localhost:8080/movies/${id}`);
    setMovie(result.data);
  };

  return (
    <div className="container p-5">
    <div className="form" >
          <legend className="text-center m-2 bg-dark-subtle">Edit movie</legend>

          <form onSubmit={(e) => onSubmit(e)}>
            
              <label htmlFor="Name" className="form-label">
                Name
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your Movie name"
                name="name"
                value={name}
                onChange={(e) => onInputChange(e)}
              />
        
              <label htmlFor="Imdb" className="form-label">
                Imdb
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your Movie imdb"
                name="imdb"
                value={imdb}
                onChange={(e) => onInputChange(e)}
              />
            
              <label htmlFor="Director" className="form-label">
                Director
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your director name"
                name="director"
                value={director}
                onChange={(e) => onInputChange(e)}
              />
                   
              <label htmlFor="Genre" className="form-label">
                Genre
              </label>
              <input
                type={"text"}
                className="form-control"
                placeholder="Enter your movie genre"
                name="genre"
                value={genre}
                onChange={(e) => onInputChange(e)}
              />
          
              <button type="submit" className="btn btn-dark m-4">
              Submit
            </button>
            <Link className="btn btn-danger mx-2" to="/">
              Cancel
            </Link>
            </form>
            
            </div>
    </div>
  );
}