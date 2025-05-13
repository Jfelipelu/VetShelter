const BASE_URL = 'http://localhost:8080/api';
const REPTILES_URL = '/reptiles';
const BIRD_URL = '/aves';
const DOGS_URL = '/caninos';
const CATS_URL = '/felinos';
const AMPHIBIANS_URL = '/anfibios';
const ANIMALS_URL = '/animals'
const TRANSACTIONS_URL = '/transactions';
const STATS_URL = '/stats';

// Animals
export const getAnimals = async () => {
  try {
    const response = await fetch(`${BASE_URL}${ANIMALS_URL}`);
    if (!response.ok) {
      throw new Error('Failed to fetch animals');
    }
    const data = await response.json();
    return data;
  } catch (error) {
    console.error(error);
    return [];
  }
};

// Reptiles
export const getReptiles = async () => {
  try {
    const response = await fetch(`${BASE_URL}${REPTILES_URL}`);
    if (!response.ok) {
      throw new Error('Failed to fetch reptiles');
    }
    const data = await response.json();
    return data;
  } catch (error) {
    console.error(error);
    return [];
  }
};

export const postReptile = async (animal) => {
  const response = await fetch(`${BASE_URL}${REPTILES_URL}`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(animal),
  });
  return await response.json();
};

// Birds
export const getBirds = async () => {
  try {
    const response = await fetch(`${BASE_URL}${BIRD_URL}`);
    if (!response.ok) {
      throw new Error('Failed to fetch birds');
    }
    const data = await response.json();
    return data;
  } catch (error) {
    console.error(error);
    return [];
  }
};

export const postBird = async (animal) => {
  const response = await fetch(`${BASE_URL}${BIRD_URL}`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(animal),
  });
  return await response.json();
};

// Dogs
export const getDogs = async () => {
  try {
    const response = await fetch(`${BASE_URL}${DOGS_URL}`);
    if (!response.ok) {
      throw new Error('Failed to fetch dogs');
    }
    const data = await response.json();
    return data;
  } catch (error) {
    console.error(error);
    return [];
  }
};

export const postDog = async (animal) => {
  const response = await fetch(`${BASE_URL}${DOGS_URL}`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(animal),
  });
  return await response.json();
};

// Cats
export const getCats = async () => {
  try {
    const response = await fetch(`${BASE_URL}${CATS_URL}`);
    if (!response.ok) {
      throw new Error('Failed to fetch cats');
    }
    const data = await response.json();
    return data;
  } catch (error) {
    console.error(error);
    return [];
  }
};

export const postCat = async (animal) => {
  const response = await fetch(`${BASE_URL}${CATS_URL}`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(animal),
  });
  return await response.json();
};

// Amphibians
export const getAmphibians = async () => {
  try {
    const response = await fetch(`${BASE_URL}${AMPHIBIANS_URL}`);
    if (!response.ok) {
      throw new Error('Failed to fetch amphibians');
    }
    const data = await response.json();
    return data;
  } catch (error) {
    console.error(error);
    return [];
  }
};

export const postAmphibian = async (animal) => {
  const response = await fetch(`${BASE_URL}${AMPHIBIANS_URL}`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(animal),
  });
  return await response.json();
};

// Transactions

export const postTransaction = async (transactionData) => {
  try {
    const response = await fetch(`${BASE_URL}${TRANSACTIONS_URL}`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(transactionData),
    });
    if (!response.ok) {
      throw new Error('Error al registrar la transacción');
    }
    return await response.json();
  } catch (error) {
    console.error(error);
    throw error;
  }
};

export const downloadTransactionsExcel = async () => {
  const res = await fetch(`${BASE_URL}${TRANSACTIONS_URL}/excel`);
  if (!res.ok) throw new Error('Error al descargar el archivo');

  const blob = await res.blob();
  const url = window.URL.createObjectURL(blob);
  const link = document.createElement('a');
  link.href = url;
  link.setAttribute('download', 'transacciones.xlsx');
  document.body.appendChild(link);
  link.click();
  document.body.removeChild(link);
};

// Business Stats

export const getStats = async () => {
  const response = await fetch(`${BASE_URL}${STATS_URL}`);
  if (!response.ok) throw new Error('Error al obtener estadísticas');
  return response.json();
};