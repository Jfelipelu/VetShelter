import React from 'react';
import { styled } from '@mui/material/styles';
import AnimalCard from './animalCard';

const Container = styled('div')(({ theme }) => ({
  padding: theme.spacing(2),
}));

const AnimalGrid = styled('div')(({ theme }) => ({
  display: 'grid',
  gridTemplateColumns: 'repeat(auto-fill, minmax(250px, 1fr))',
  gap: theme.spacing(3),
  marginTop: theme.spacing(2),
}));

const AnimalList = ({ animals }) => {
  console.log(animals)
  return (
    <Container>
      <AnimalGrid>
        {animals.map((animal) => (
          <AnimalCard key={animal.id} animal={animal} />
        ))}
      </AnimalGrid>
    </Container>
  );
};

export default AnimalList;