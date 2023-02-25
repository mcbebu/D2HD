import React, { useState, useEffect } from "react";
import dynamic from "next/dynamic";
import { defineStyle, defineStyleConfig } from "@chakra-ui/react";
import { Flex, Spacer, Text, Heading, Divider, Image } from "@chakra-ui/react";
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
// const photos = [run_1, run_2, run_3, run_4, run_5, run_6];
// const photoList = [false, false, true, false, false];
// const [count, setCount] = useState(0);
// for (let i = 0; i < photoList.length; i++) {
//   if (photoList[i] === true) {
//     setPhoto(photos[i]);
//   }
// }
// console.log(photo)

const Consignee = () => {
  return (
    <Flex className="Layout Parent" id="top" minWidth="100%" direction="column">
      <Flex width="100%" flexDir="column" className="Content Parent">
        <Navbar />
        <Home />
      </Flex>
    </Flex>
  );
};
const Home = () => {
  const [address, setAddress] = useState([]);
  useEffect(() => {
    DeliveryService.getWayPoint().then((res) => {
      console.log(res.data);
      setAddress(res.data.address);
    });
  }, []);

  // useEffect(() => {
  //   axios
  //     .get("http://localhost:8080/api/waypoint/getWaypoint")
  //     .then((res) => {
  //       console.log(res.data.address);
  //       setAddress({ state: res.data });
  //     })
  //     .catch((err) => {
  //       console.log(err);
  //     });
  // }, []);

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
          height="70rem"
          background="#fff"
          borderRadius="20px"
          flexDir="column"
          className="content"
        >
          <Heading color="#000" padding="2rem">
            Estimated Delivery
          </Heading>
          <Divider colorScheme="gray" variant="solid" />
          <Text fontWeight="bold">26 Feb 2021, by 10:00 pm</Text>
          <Heading color="#000" padding="2rem">
            Tracking History
          </Heading>
          <Flex p="2rem">
            <Image src={run_1.src} />
          </Flex>
          <Flex justify="center">
            <Text color="#000">Test</Text>
            {address ? <Text color="#000">{address}</Text> : null}
          </Flex>
        </Flex>
      </Flex>
    </Flex>
  );
};

export default Consignee;
