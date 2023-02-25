import { ChakraProvider } from "@chakra-ui/react";

function Website({ Component, pageProps }) {
  return (
    <>
      <ChakraProvider>
        <Component {...pageProps} />
      </ChakraProvider>
    </>
  );
}
export default Website;
