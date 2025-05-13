import React from 'react';

import { CardContainer, AnimalName, AnimalDetails, InfoContainer } from './animalCardStyles';

const AnimalCard = ({ animal }) => {

  return (
    <CardContainer role="button">
      <InfoContainer>
        <div>
          <AnimalName>{animal.name}</AnimalName>
          <AnimalDetails><strong>Especie :</strong> {animal.species}</AnimalDetails>
          <AnimalDetails><strong>Raza :</strong> {animal.breed}</AnimalDetails>
          <AnimalDetails><strong>Edad :</strong> {animal.age}</AnimalDetails>
          <AnimalDetails><strong>{animal.available ? 'Disponible' : 'No Disponible'}</strong></AnimalDetails>
          <AnimalDetails><strong>Estado de salud :</strong> {animal.health}</AnimalDetails>
          <AnimalDetails><strong>Vacunas :</strong> {animal.vaccine ? 'Sí' : 'No'}</AnimalDetails>
          <AnimalDetails><strong>Con nosotros desde :</strong> {animal.admissionDate}</AnimalDetails>
          {
          animal.venomous
            ? <AnimalDetails><strong>{animal.venomous ? 'Venenoso' : 'No Venenoso'}</strong></AnimalDetails>
            : null
          }
          {
          animal.habitat
            ? <AnimalDetails><strong>Habitat :</strong>{animal.habitat}</AnimalDetails>
            : null
          }
        </div>
      </InfoContainer>
    </CardContainer>
  );
};

export default AnimalCard;