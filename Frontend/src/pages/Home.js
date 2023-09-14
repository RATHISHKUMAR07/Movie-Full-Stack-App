import React, { useEffect, useState } from 'react'
import axios from 'axios';
import { Link, useParams } from 'react-router-dom';
export default function Home() {

    const [movies, setMovies] = useState([]);

    const { id } = useParams();

    useEffect(() => {
        loadMovies();
    }, [])

    const loadMovies = async () => {
        const result = await axios.get("http://localhost:8080/movies");
        setMovies(result.data);
    }

    const deleteMovie = async (id) => {
        await axios.delete(`http://localhost:8080/movies/${id}`);
        loadMovies();
    }

    return (
        <div className='container'>
            <div className='py-4 '>
                <table className="table border-dark-subtle shadow ">
                    <thead className='border-bottom-black'>
                        <tr className='bg-dark'>
                            <th scope="col">S.No</th>
                            <th scope="col">Name</th>
                            <th scope="col">Imdb</th>
                            <th scope="col">Director</th>
                            <th scope="col">Genre</th>
                            <th scope='col'>Action</th>
                        </tr>
                    </thead>
                    <tbody>
                        {movies.map((movie, index) => (
                                <tr>
                                <th scope="row" key={index}>{index+1}</th>
                                    <td>{movie.name}</td>
                                    <td>{movie.imdb}</td>
                                    <td>{movie.director}</td>
                                    <td>{movie.genre}</td>
                                    <td>
                                        <Link className='btn btn-primary mx-2' to={`/viewmovie/${movie.id}`}>View</Link>
                                        <Link className='btn btn-dark mx-2'
                                            to={`/editmovie/${movie.id}`}
                                        >Edit</Link>
                                    <button className='btn btn-danger mx-2'
                                    onClick={() => deleteMovie(movie.id)}
                                    >Delete</button>

                                    </td>
                                </tr>
                            ))
                        }

                    </tbody>
                </table>
            </div>
        </div>
    )
}
