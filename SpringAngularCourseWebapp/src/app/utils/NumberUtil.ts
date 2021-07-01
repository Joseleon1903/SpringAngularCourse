

//return random number between and  numberMax
export function getRandomNumberMax(numberMax :number): number{
  const rndInt = Math.floor(Math.random() * numberMax) + 1;
  return rndInt;
}
