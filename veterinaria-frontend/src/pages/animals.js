import React, { useEffect, useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import AnimalList from '../components/animals/animalsList';

import {
  getAnimals,
  getDogs,
  getCats,
  getBirds,
  getReptiles,
  getAmphibians
} from '../services/vetApi';

const Animals = () => {
  const [animals, setAnimals] = useState([]);
  const [loading, setLoading] = useState(true);
  const [species, setSpecies] = useState('all');

  const fetchBySpecies = async (species) => {
    switch (species) {
      case 'Canino':
        return await getDogs();
      case 'Felino':
        return await getCats();
      case 'Ave':
        return await getBirds();
      case 'Reptil':
        return await getReptiles();
      case 'Anfibio':
        return await getAmphibians();
      default:
        return await getAnimals();
    }
  };

  useEffect(() => {
    const fetchData = async () => {
      setLoading(true);
      const data = await fetchBySpecies(species);
      setAnimals(data);
      setLoading(false);
    };

    fetchData();
  }, [species]);

  if (loading) {
    return <div>Loading...</div>;
  }

  return (
    <div style={{ marginLeft: 20 }}>
      <h2>Animales en el refugio</h2>

      <label>Filtrar por especie: </label>
      <select
        id="species-select"
        value={species}
        onChange={(e) => setSpecies(e.target.value)}
      >
        <option value="all">Todos</option>
        <option value="Canino">Caninos</option>
        <option value="Felino">Felinos</option>
        <option value="Ave">Aves</option>
        <option value="Reptil">Reptiles</option>
        <option value="Anfibio">Anfibios</option>
      </select>

      <Routes>
        <Route path="/" element={<AnimalList animals={animals} />} />
      </Routes>
    </div>
  );
};

export default Animals;