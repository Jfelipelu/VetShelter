import React from 'react';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import { Link } from 'react-router-dom';

const Navbar = () => {
  return (
    <AppBar position="static" sx={{ backgroundColor: '#2C3E50' }}>
      <Toolbar sx={{ justifyContent: 'space-between' }}>
        <Typography variant="h6" component="div" sx={{ flexGrow: 1, fontWeight: 'bold' }}>
          Huellas Diversas
        </Typography>
        <div>
          <Button
            color="inherit"
            component={Link}
            to="/stats"
            sx={{
              marginLeft: 2,
              borderRadius: 2,
              '&:hover': {
                backgroundColor: '#34495E',
              },
            }}
          >
            Estadísticas generales
          </Button>
          <Button
            color="inherit"
            component={Link}
            to="/create-transaction"
            sx={{
              marginLeft: 2,
              borderRadius: 2,
              '&:hover': {
                backgroundColor: '#34495E',
              },
            }}
          >
            Transacciones
          </Button>
          <Button
            color="inherit"
            component={Link}
            to="/create-animal"
            sx={{
              marginLeft: 2,
              borderRadius: 2,
              '&:hover': {
                backgroundColor: '#34495E',
              },
            }}
          >
            Ingresar Animal
          </Button>
          <Button
            color="inherit"
            component={Link}
            to="/animals"
            sx={{
              marginLeft: 2,
              borderRadius: 2,
              '&:hover': {
                backgroundColor: '#34495E',
              },
            }}
          >
            Animales
          </Button>
        </div>
      </Toolbar>
    </AppBar>
  );
};

export default Navbar;