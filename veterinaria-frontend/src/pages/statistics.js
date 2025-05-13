import React, { useEffect, useState } from 'react';
import {
  Container,
  Typography,
  CircularProgress,
  Grid,
  Card,
  CardContent,
  List,
  ListItem,
  ListItemIcon,
  ListItemText,
  Divider,
} from '@mui/material';
import PetsIcon from '@mui/icons-material/Pets';
import FavoriteIcon from '@mui/icons-material/Favorite';
import HomeIcon from '@mui/icons-material/Home';
import CategoryIcon from '@mui/icons-material/Category';
import { getStats } from '../services/vetApi';

const StatisticCard = ({ icon, label, value }) => (
  <Card elevation={3} sx={{ minWidth: 200 }}>
    <CardContent sx={{ textAlign: 'center' }}>
      <ListItemIcon sx={{ justifyContent: 'center', mb: 1 }}>
        {icon}
      </ListItemIcon>
      <Typography variant="h6">{label}</Typography>
      <Typography variant="h4" color="primary">{value}</Typography>
    </CardContent>
  </Card>
);

const StatisticsPage = () => {
  const [stats, setStats] = useState(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    getStats()
      .then(setStats)
      .finally(() => setLoading(false));
  }, []);

  if (loading) {
    return (
      <Container sx={{ textAlign: 'center', mt: 5 }}>
        <CircularProgress />
        <Typography variant="body1" mt={2}>Cargando estadísticas...</Typography>
      </Container>
    );
  }

  return (
    <Container sx={{ mt: 4 }}>
      <Typography variant="h4" gutterBottom align="center">
        Estadísticas del Refugio
      </Typography>

      <Grid container spacing={3} justifyContent="center" sx={{ mb: 4 }}>
        <Grid item>
          <StatisticCard
            icon={<PetsIcon color="primary" fontSize="large" />}
            label="Total de animales"
            value={stats.totalAnimales}
          />
        </Grid>
        <Grid item>
          <StatisticCard
            icon={<FavoriteIcon color="secondary" fontSize="large" />}
            label="Adopciones"
            value={stats.totalAdopciones}
          />
        </Grid>
        <Grid item>
          <StatisticCard
            icon={<HomeIcon color="success" fontSize="large" />}
            label="Acogidas"
            value={stats.totalAcogidas}
          />
        </Grid>
      </Grid>

      <Divider sx={{ my: 3 }} />

      <Typography variant="h5" gutterBottom>
        Animales por especie
      </Typography>
      <List>
        {Object.entries(stats.totalPorEspecie).map(([species, count]) => (
          <ListItem key={species}>
            <ListItemIcon>
              <CategoryIcon />
            </ListItemIcon>
            <ListItemText primary={`${species}: ${count}`} />
          </ListItem>
        ))}
      </List>
    </Container>
  );
};

export default StatisticsPage;