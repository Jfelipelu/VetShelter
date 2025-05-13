import { styled } from '@mui/material/styles';

export const CardContainer = styled('div')(({ theme }) => ({
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center',
  cursor: 'pointer',
  border: '1px solid #ccc',
  borderRadius: '8px',
  padding: theme.spacing(2),
  transition: 'transform 0.3s ease',
  '&:hover': {
    transform: 'scale(1.05)',
  },
}));

export const AnimalImage = styled('img')(({ theme }) => ({
  width: '100%',
  borderRadius: '8px',
  objectFit: 'cover',
  height: '200px',
}));

export const AnimalName = styled('h3')(({ theme }) => ({
  fontSize: '1.25rem',
  fontWeight: 'bold',
  margin: 0,
  width: '80%'
}));

export const AnimalDetails = styled('p')(({ theme }) => ({
  fontSize: '1rem',
  margin: '4px 0',
}));

export const InfoContainer = styled('div')(({ theme }) => ({
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'flex-start',
  justifyContent: 'space-between',
  width: '100%',
  marginTop: theme.spacing(1),
}));

export const SingleCardContainer = styled('div')(({ theme }) => ({
  display: 'flex',
  flexDirection: 'column',
  alignItems: 'center',
  border: '1px solid #ccc',
  borderRadius: '8px',
  padding: theme.spacing(2),
  height: '100vh'
}));

export const SingleAnimalImage = styled('img')(({ theme }) => ({
  width: '100%',
  height: 'auto',
  maxWidth: '500px',
  borderRadius: '8px',
  objectFit: 'cover',
  marginBottom: theme.spacing(2),
}));

export const SingleAnimalName = styled('h2')(({ theme }) => ({
  fontSize: '2rem',
  fontWeight: 'bold',
  marginBottom: theme.spacing(1),
}));

export const SingleAnimalDetails = styled('p')(({ theme }) => ({
  fontSize: '1.2rem',
  marginBottom: theme.spacing(1),
  color: '#333',
}));

export const SingleInfoContainer = styled('div')(({ theme }) => ({
  display: 'flex',
  flexDirection: 'column',
  width: '80%',
  alignItems: 'flex-start',
  border: '1px solid #ccc',
  borderRadius: '8px',
  padding: 20
}));