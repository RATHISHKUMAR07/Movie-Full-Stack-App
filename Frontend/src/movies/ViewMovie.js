import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link, useParams } from 'react-router-dom'
import '../view.css'
export default function ViewMovie() {

    const [movie, setMovie] = useState({
        name: "",
        imdb: "",
        director: "",
        genre: "",
    })

    const { id } = useParams();

    useEffect(() => {
        loadMovie();
    }, [])

    const loadMovie = async () => {
        const result = await axios.get(`http://localhost:8080/movies/${id}`);
        setMovie(result.data);
    }
    return (
        <div className='view'>
            <div className="container">
                <div className='form'>
                <legend className="text-center m-2 bg-dark-subtle ">Movie Details</legend>
           
                    <p className='text-decoration-underline'>Details of Movie id : {id}</p>
                    <ul >
                        <li >
                            <b>Name : </b>
                            <p>{movie.name}</p>
                        </li>
                        <li >
                            <b>Imdb : </b>
                            <p>{movie.imdb}</p>
                        </li>
                        <li >
                            <b>Director : </b>
                            <p>{movie.director}</p>
                        </li>
                        <li >
                            <b>Genre : </b>
                            <p>{movie.genre}</p>
                        </li>
                    </ul>
                    <Link className='btn btn-success my-2' to={"/"}>
                        Back to Home
                    </Link>
                    </div>
                    
            </div>
            </div>
            )
}
