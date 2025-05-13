import React, { useState, useEffect } from 'react';
import {
  Container,
  TextField,
  MenuItem,
  Button,
  Typography,
  Grid,
} from '@mui/material';
import { getAnimals, postTransaction, downloadTransactionsExcel } from '../services/vetApi';

const TransactionForm = () => {
  const [animals, setAnimals] = useState([]);
  const [formData, setFormData] = useState({
    animalId: '',
    transactionType: '',
    personName: '',
    date: '',
  });

  useEffect(() => {
    const fetchAnimals = async () => {
      const data = await getAnimals();
      setAnimals(data);
    };
    fetchAnimals();
  }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prev) => ({ ...prev, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await postTransaction({
        animal: { id: formData.animalId },
        type: formData.transactionType,
        responsible: formData.personName,
        date: formData.date,
      });
      alert('Transacción registrada con éxito');
      setFormData({
        animalId: '',
        transactionType: '',
        personName: '',
        date: '',
      });
    } catch (error) {
      console.error(error);
      alert('Error al registrar la transacción');
    }
  };

  return (
    <Container maxWidth="sm">
      <Typography style={{ marginTop: 20 }} variant="h5" gutterBottom>Registrar Adopción o Acogida</Typography>
      <form onSubmit={handleSubmit}>
        <Grid container spacing={2}>
          <Grid item xs={12}>
            <TextField
              select
              fullWidth
              label="Animal"
              name="animalId"
              value={formData.animalId}
              onChange={handleChange}
              required
            >
              {animals.map((animal) => (
                <MenuItem key={animal.id} value={animal.id}>
                  {animal.name} ({animal.species})
                </MenuItem>
              ))}
            </TextField>
          </Grid>

          <Grid item xs={12}>
            <TextField
              select
              fullWidth
              label="Tipo de transacción"
              name="transactionType"
              value={formData.transactionType}
              onChange={handleChange}
              required
            >
              <MenuItem value="adopción">Adopción</MenuItem>
              <MenuItem value="acogida">Acogida</MenuItem>
            </TextField>
          </Grid>

          <Grid item xs={12}>
            <TextField
              fullWidth
              label="Nombre de la persona"
              name="personName"
              value={formData.personName}
              onChange={handleChange}
              required
            />
          </Grid>

          <Grid item xs={12}>
            <TextField
              fullWidth
              type="date"
              label="Fecha"
              name="date"
              value={formData.date}
              onChange={handleChange}
              required
              InputLabelProps={{
                shrink: true,
              }}
            />
          </Grid>

          <Grid item xs={12}>
            <Button variant="contained" type="submit" fullWidth>
              Registrar
            </Button>
          </Grid>
        </Grid>
      </form>
      <Grid style={{ marginTop: 20 }} item xs={12}>
        <Button
          variant="outlined"
          color="primary"
          fullWidth
          onClick={downloadTransactionsExcel}
        >
          Descargar Transacciones en Excel
        </Button>
      </Grid>
    </Container>
  );
};

export default TransactionForm;