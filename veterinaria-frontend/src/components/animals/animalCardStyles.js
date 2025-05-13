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