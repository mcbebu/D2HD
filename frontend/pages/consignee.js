import React, { useState, useEffect } from "react";
import { AiTwotoneCalendar } from "react-icons/ai";
import dynamic from "next/dynamic";
import { defineStyle, defineStyleConfig, Button } from "@chakra-ui/react";
import { Flex, Spacer, Text, Heading, Divider, Image, Icon } from "@chakra-ui/react";
const Navbar = dynamic(() => import("../client/Navbar"));
const MARGIN = "11vh";
const xl = defineStyle({
  border: "10px solid",
  borderRadius: "lg",
});
import run_1 from "../public/ninja_run/1.png";
import run_2 from "../public/ninja_run/2.png";
import run_3 from "../public/ninja_run/3.png";
import run_4 from "../public/ninja_run/4.png";
import run_5 from "../public/ninja_run/5.png";
import run_6 from "../public/ninja_run/6.png";
import DeliveryService from "../api/delivery";

// const photoList = [false, false, true, false, false];
// const [count, setCount] = useState(0);

// console.log(photo)

const Consignee = () => {
  return (
    <Flex className="Layout Parent" id="top" minWidth="100%" direction="column">
      <Flex width="100%" flexDir="column" className="Content Parent">
        <Navbar />
        <Home />
        <Tracking />
      </Flex>
    </Flex>
  );
};
const Home = () => {
  const photos = [ run_2.src, run_3.src, run_4.src, run_5.src, run_6.src ];
  const [delivery, setDelivery] = useState([]);
  useEffect(() => {
    DeliveryService.getUpdatedDeliveryList().then((res) => {
      setDelivery(res.data);
    });
  }, []);
  console.log(delivery);
  const getTrackingImage = () => {
    for (let i = delivery.length - 1; i > 0; i--) {
      if (delivery[i].is_completed === true) {
        return <Image src={photos[i]} />;
      }
    }
    return <Image src={run_1.src} />;
  };

  return (
    <Flex
      className="Hero Parent"
      id="top"
      minWidth="100%"
      direction="column"
      backgroundColor="#E8EDF0"
    >
      <Flex
        width="100%"
        flexDir="column"
        className="Content Parent"
        alignItems="center"
      >
        <Flex
          marginTop={MARGIN}
          w="50rem"
          height="60rem"
          background="#fff"
          borderRadius="20px"
          flexDir="column"
          className="content"
        >
          <Heading color="#000" padding="2rem">
            Estimated Delivery
          </Heading>
          <Divider colorScheme="" />
          <Flex alignItems="center" pl='10' pt='4' pb='5'>
            <Icon as={AiTwotoneCalendar} mr={2} />
            <Text fontWeight="bold">15 Feb 2023 to 24 Feb 2023, by 10:00 pm</Text>
          </Flex>
          <Text fontWeight="bold" pl='10' pt='3' pb='5'><AiTwotoneCalendar/>15 Feb 2023 to 24 Feb 2023, by 10:00 pm</Text>
          <Heading color="#000" padding="2rem">
            Tracking History
          </Heading>
          <Flex p="2rem" direction="column">
            {getTrackingImage()}
          </Flex>
          <Flex justify="center" flexDir="center">
            <Text color="#000">Test</Text>
            <Button colorScheme="face">Fail</Button>
          </Flex>
        </Flex>
      </Flex>
    </Flex>
  );
};

const Tracking = () => {
  return (
    <Flex
      className="Tracking Parent"
      id="top"
      minWidth="100%"
      direction="column"
      backgroundColor="#E8EDF0"
    >
      <Flex
        width="100%"
        flexDir="column"
        className="Content Parent"
        alignItems="center"
      >
        <Flex
          marginTop={MARGIN}
          w="50rem"
          height="60rem"
          background="#fff"
          borderRadius="20px"
          flexDir="column"
          className="content"
        >
          <Heading color="#000" padding="2rem">
            Tracking History
          </Heading>
          <Divider colorScheme="" />
          <Flex alignItems="center" pl='10' pt='4' pb='5'>
            <Icon mr={2} />
            <Flex flexDirection='column'>
              <Text fontWeight="bold">Successfully delivered</Text>
              <Text fontWeight="bold" textColor='gray.400' fontSize='xs' pt='1'>15 Feb 23, 9:53 am</Text>
            </Flex>
          </Flex>
          <Flex alignItems="center" pl='10' pt='4' pb='5'>
            <Icon mr={2} />
            <Flex flexDirection='column'>
              <Text fontWeight="bold">Successfully delivered</Text>
              <Text fontWeight="bold" textColor='gray.400' fontSize='xs' pt='1'>4 Feb 23, 12:00 pm</Text>
            </Flex>
          </Flex>
          <Flex alignItems="center" pl='10' pt='4' pb='5'>
            <Icon mr={2} />
            <Flex flexDirection='column'>
              <Text fontWeight="bold">Parcel is being processed at Ninja Van warehouse - Ninja Van Sorting Facility</Text>
              <Text fontWeight="bold" textColor='gray.400' fontSize='xs' pt='1'>4 Feb 23, 12:00 pm</Text>
            </Flex>
          </Flex>
          <Flex alignItems="center" pl='10' pt='4' pb='5'>
            <Icon mr={2} />
            <Flex flexDirection='column'>
              <Text fontWeight="bold">Order created</Text>
              <Text fontWeight="bold" textColor='gray.400' fontSize='xs' pt='1'>3 Feb 23, 11:53 pm</Text>
            </Flex>
          </Flex>
        </Flex>
      </Flex>
    </Flex>
  );
};

export default Consignee;
