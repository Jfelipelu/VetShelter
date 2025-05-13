import React, { useState } from 'react';
import {
  postDog,
  postCat,
  postBird,
  postReptile,
  postAmphibian,
} from '../services/vetApi';

import {
  Container,
  TextField,
  Select,
  MenuItem,
  InputLabel,
  FormControl,
  FormControlLabel,
  Checkbox,
  Button,
  Typography,
  Box,
} from '@mui/material';

const AnimalForm = () => {
  const [animalData, setAnimalData] = useState({
    name: '',
    species: '',
    breed: '',
    age: '',
    health: '',
    available: false,
    vaccine: false,
    admissionDate: '',
    transactionDate: '',
    trained: false,
    canFly: false,
    furLength: '',
    venomous: false,
    habitat: '',
    aquatic: false,
  });

  const handleChange = (e) => {
    const { name, value, type, checked } = e.target;
    setAnimalData((prev) => ({
      ...prev,
      [name]: type === 'checkbox' ? checked : value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      const { species, ...rest } = animalData;

      let dataToSend = { ...rest, species };

      switch (species) {
        case 'Canino':
          await postDog(dataToSend);
          break;
        case 'Felino':
          await postCat(dataToSend);
          break;
        case 'Ave':
          await postBird(dataToSend);
          break;
        case 'Reptil':
          await postReptile(dataToSend);
          break;
        case 'Anfibio':
          await postAmphibian(dataToSend);
          break;
        default:
          alert('Especie no válida');
          return;
      }

      alert('Animal registrado con éxito');
      setAnimalData({
        name: '',
        species: '',
        breed: '',
        age: '',
        health: '',
        available: false,
        vaccine: false,
        admissionDate: '',
        transactionDate: '',
        trained: false,
        canFly: false,
        furLength: '',
        venomous: false,
        habitat: '',
        aquatic: false,
      });
    } catch (error) {
      console.error(error);
      alert('Hubo un error al registrar el animal');
    }
  };

  return (
    <Container maxWidth="sm">
      <Box sx={{ mt: 4 }}>
        <Typography variant="h4" gutterBottom>
          Registrar nuevo animal
        </Typography>
        <form onSubmit={handleSubmit}>
          <TextField
            fullWidth
            margin="normal"
            label="Nombre"
            name="name"
            value={animalData.name}
            onChange={handleChange}
            required
          />

          <FormControl fullWidth margin="normal" required>
            <InputLabel>Especie</InputLabel>
            <Select
              name="species"
              value={animalData.species}
              onChange={handleChange}
              label="Especie"
            >
              <MenuItem value="Canino">Canino</MenuItem>
              <MenuItem value="Felino">Felino</MenuItem>
              <MenuItem value="Ave">Ave</MenuItem>
              <MenuItem value="Reptil">Reptil</MenuItem>
              <MenuItem value="Anfibio">Anfibio</MenuItem>
            </Select>
          </FormControl>

          <TextField
            fullWidth
            margin="normal"
            label="Raza"
            name="breed"
            value={animalData.breed}
            onChange={handleChange}
            required
          />

          <TextField
            fullWidth
            margin="normal"
            label="Edad"
            name="age"
            type="number"
            inputProps={{ min: 0 }}
            value={animalData.age}
            onChange={handleChange}
            required
          />

          <TextField
            fullWidth
            margin="normal"
            label="Estado de salud"
            name="health"
            value={animalData.health}
            onChange={handleChange}
            required
          />

          <TextField
            fullWidth
            margin="normal"
            type="date"
            name="admissionDate"
            value={animalData.admissionDate}
            onChange={handleChange}
            required
            label="Fecha de admisión"
            InputLabelProps={{ shrink: true }}
          />

          <TextField
            fullWidth
            margin="normal"
            type="date"
            name="transactionDate"
            value={animalData.transactionDate}
            onChange={handleChange}
            required
            label="Fecha de transacción"
            InputLabelProps={{ shrink: true }}
          />

          <FormControlLabel
            control={
              <Checkbox
                name="vaccine"
                checked={animalData.vaccine}
                onChange={handleChange}
              />
            }
            label="Vacunado"
          />

          <FormControlLabel
            control={
              <Checkbox
                name="available"
                checked={animalData.available}
                onChange={handleChange}
              />
            }
            label="Disponible para adopción"
          />

          {animalData.species === 'Canino' && (
            <FormControlLabel
              control={
                <Checkbox
                  name="trained"
                  checked={animalData.trained}
                  onChange={handleChange}
                />
              }
              label="Entrenado"
            />
          )}

          {animalData.species === 'Felino' && (
            <TextField
              fullWidth
              margin="normal"
              label="Longitud del pelaje"
              name="furLength"
              value={animalData.furLength}
              onChange={handleChange}
              inputProps={{ minLength: 5, maxLength: 12 }}
              required
            />
          )}

          {animalData.species === 'Ave' && (
            <FormControlLabel
              control={
                <Checkbox
                  name="canFly"
                  checked={animalData.canFly}
                  onChange={handleChange}
                />
              }
              label="Puede volar"
            />
          )}

          {animalData.species === 'Reptil' && (
            <>
              <FormControlLabel
                control={
                  <Checkbox
                    name="venomous"
                    checked={animalData.venomous}
                    onChange={handleChange}
                  />
                }
                label="Venenoso"
              />
              <TextField
                fullWidth
                margin="normal"
                label="Hábitat"
                name="habitat"
                value={animalData.habitat}
                onChange={handleChange}
                required
              />
            </>
          )}

          {animalData.species === 'Anfibio' && (
            <FormControlLabel
              control={
                <Checkbox
                  name="aquatic"
                  checked={animalData.aquatic}
                  onChange={handleChange}
                />
              }
              label="Es acuático"
            />
          )}

          <Box sx={{ mt: 2 }}>
            <Button type="submit" variant="contained" color="primary" fullWidth>
              Registrar
            </Button>
          </Box>
        </form>
      </Box>
    </Container>
  );
};

export default AnimalForm;