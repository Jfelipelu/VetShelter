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
            animal.venomous !== undefined
              ? <AnimalDetails><strong>{animal.venomous ? 'Venenoso' : 'No Venenoso'}</strong></AnimalDetails>
              : null
          }
          {
            animal.habitat !== undefined
              ? <AnimalDetails><strong>Habitat :</strong> {animal.habitat}</AnimalDetails>
              : null
          }
          {
            animal.furLength !== undefined
              ? <AnimalDetails><strong>Tipo de pelaje :</strong> {animal.furLength}</AnimalDetails>
              : null
          }
          {
            animal.trained !== undefined
              ? <AnimalDetails><strong>{animal.trained ? 'Entrenado' : 'No entrenado'}</strong></AnimalDetails>
              : null
          }
          {
            animal.canFly !== undefined
              ? <AnimalDetails><strong>{animal.canFly ? 'Volador' : 'No volador'}</strong></AnimalDetails>
              : null
          }
          {
            animal.aquatic !== undefined
              ? <AnimalDetails><strong>{animal.aquatic ? 'Acuático' : 'No acuático'}</strong></AnimalDetails>
              : null
          }
        </div>
      </InfoContainer>
    </CardContainer>
  );
};

export default AnimalCard;