import React, { useState, useEffect } from "react";
import dynamic from "next/dynamic";
import {
  defineStyle,
  defineStyleConfig,
  Button,
  Flex,
  Spacer,
  Text,
  Heading,
  Divider,
  Image,
  Icon,
} from "@chakra-ui/react";
import { AiTwotoneCalendar, AiOutlineHistory } from "react-icons/ai";
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
import run_7 from "../public/ninja_run/7.png";
import DeliveryService from "../api/delivery";
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
  const photos = [run_2.src, run_3.src, run_4.src, run_5.src, run_6.src];
  const [delivery, setDelivery] = useState([]);
  let time = "";
  useEffect(() => {
    DeliveryService.clusterUpdate().then((res) => {
      setDelivery(res.data);
    });
    console.log(delivery);
    getTrackingImage();
  }, []);

  //A B (me)
  // T F
  // A B C (me)
  // T T F
  //A B C D (me)
  //T T F F
  // const delivery = [
  //   { hasVisited: true },
  //   { hasVisited: true },
  //   { hasVisited: true },
  //   { hasVisited: true },
  //   { hasVisited: true },
  // ];
  console.log(delivery.length);
  const getTrackingImage = () => {
    //check for one boolean
    if (delivery.length === 1) {
      if (delivery[0].hasVisited === false) {
        return <Image src={photos[3]} w="550px" alignSelf="center" />;
      }
      return <Image src={photos[4]} w="550px" alignSelf="center" />;
    }
    //check for one boolean
    else if (delivery.length === 2) {
      if (delivery[0].hasVisited === false) {
        return <Image src={photos[2]} w="550px" alignSelf="center" />;
      } else if (delivery[1].hasVisited === false) {
        return <Image src={photos[3]} w="550px" alignSelf="center" />;
      }
      return <Image src={photos[4]} w="550px" alignSelf="center" />;
    }
    //check for 3 boolean
    else if (delivery.length === 3) {
      if (delivery[0] === false) {
        return <Image src={photos[1]} w="550px" alignSelf="center" />;
      } else if (delivery[1].hasVisited === false) {
        return <Image src={photos[2]} w="550px" alignSelf="center" />;
      } else if (delivery[2].hasVisited === false) {
        return <Image src={photos[3]} w="550px" alignSelf="center" />;
      }
      return <Image src={photos[4]} w="550px" alignSelf="center" />;
    }
    //check for 4 boolean
    else if (delivery.length === 4) {
      if (delivery[0].hasVisited === false) {
        return <Image src={run_1.src} w="550px" alignSelf="center" />;
      }
      if (delivery[1] === false) {
        return <Image src={photos[0]} w="550px" alignSelf="center" />;
      } else if (delivery[2].hasVisited === false) {
        return <Image src={photos[2]} w="550px" alignSelf="center" />;
      } else if (delivery[3].hasVisited === false) {
        return <Image src={photos[3]} w="550px" alignSelf="center" />;
      } else if (delivery[4].hasVisited === false) {
        return <Image src={photos[4]} w="550px" alignSelf="center" />;
      }
      return <Image src={photos[5]} w="550px" alignSelf="center" />;
    }
    //check for more than 4 boolean
    else if (delivery.length > 4) {
      if (delivery[0].hasVisited === false) {
        time = ">60";
        return <Image src={run_1.src} w="550px" alignSelf="center" />;
      } else if (delivery[1].hasVisited === false) {
        time = "50";
        return <Image src={photos[0]} w="550px" alignSelf="center" />;
      } else if (delivery[2].hasVisited === false) {
        time = "40";
        return <Image src={photos[1]} w="550px" alignSelf="center" />;
      } else if (delivery[3].hasVisited === false) {
        time = "30";
        return <Image src={photos[2]} w="550px" alignSelf="center" />;
      } else if (delivery[4].hasVisited === false) {
        time = "20";
        return <Image src={photos[3]} w="550px" alignSelf="center" />;
      } else {
        time = "10";
        return <Image src={photos[4]} w="550px" alignSelf="center" />;
      }
    }
    //Returns default image
    return <Image src={run_1.src} w="550px" alignSelf="center" />;
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
          w="50rem"
          background="#fff"
          borderRadius="20px"
          flexDir="column"
          className="content"
        >
          <Image
            maxWidth="auto"
            height="300px"
            alignSelf="center"
            src="https://raw.githubusercontent.com/mcbebu/D2HD/c89a3fd10178f1a389db68e5fb1b0dca4a3df2b5/frontend/public/tracking.png"
            alt="tracking img"
          />
          <Heading color="#000" px="2rem">
            Estimated Delivery
          </Heading>
          <Divider colorScheme="" />
          <Flex alignItems="center" pl="10" pt="4" pb="5" color="gray">
            <Icon as={AiTwotoneCalendar} mr={2} />
            <Text fontWeight="bold">
              10 Feb 2023 to 24 Feb 2023, by 10:00 pm
            </Text>
          </Flex>
          <Flex alignItems="center" pl="10" pt="4" pb="5" color="gray">
            <Icon as={AiTwotoneCalendar} mr={2} />
            <Text fontWeight="bold">
              15 Feb 2023 to 24 Feb 2023, by 10:00 pm
            </Text>
          </Flex>

          <Heading color="#000" px="2rem" py="1rem">
            Your Order Status - Draco Malfoy
          </Heading>
          <Flex direction="column" justifyContent="center">
            {getTrackingImage()}
            <Flex alignItems="center" pl="10" pt="4" pb="5" color="gray">
              <Icon as={AiTwotoneCalendar} mr={2} />
              <Text fontWeight="bold">
                Approximate time of arrival : {time} mins
              </Text>
            </Flex>
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
          height="auto"
          background="#fff"
          borderRadius="20px"
          flexDir="column"
          className="content"
          pb="2"
          mb="10"
        >
          <Heading color="#000" padding="2rem">
            Tracking History
          </Heading>
          <Divider colorScheme="" />
          {/* <Flex alignItems="center" pl='10' pt='4' pb='5'>
            <Icon as={AiOutlineHistory} mr={2} />
            <Flex flexDirection='column'>
              <Text fontWeight="bold">Successfully delivered</Text>
              <Text fontWeight="bold" textColor='gray.400' fontSize='xs' pt='1'>5 Feb 23, 9:53 pm</Text>
            </Flex>
          </Flex> */}
          <Flex alignItems="center" pl="10" pt="4" pb="5">
            <Icon as={AiOutlineHistory} color="gray.500" mr={2} />
            <Flex flexDirection="column">
              <Text fontWeight="bold" color="gray.500">
                Parcel is on its way
              </Text>
              <Text fontWeight="bold" textColor="gray.500" fontSize="xs" pt="1">
                5 Feb 23, 8:22 am
              </Text>
            </Flex>
          </Flex>
          <Flex alignItems="center" pl="10" pt="4" pb="5">
            <Icon as={AiOutlineHistory} color="gray.500" mr={2} />
            <Flex flexDirection="column">
              <Text fontWeight="bold" color="gray.500">
                Parcel is being processed at Ninja Van warehouse - Ninja Van
                Sorting Facility
              </Text>
              <Text fontWeight="bold" textColor="gray.500" fontSize="xs" pt="1">
                4 Feb 23, 12:00 pm
              </Text>
            </Flex>
          </Flex>
          <Flex alignItems="center" pl="10" pt="4" pb="5">
            <Icon as={AiOutlineHistory} color="gray.500" mr={2} />
            <Flex flexDirection="column">
              <Text fontWeight="bold" color="gray.500">
                Order created
              </Text>
              <Text fontWeight="bold" textColor="gray.500" fontSize="xs" pt="1">
                3 Feb 23, 11:53 pm
              </Text>
            </Flex>
          </Flex>
        </Flex>
      </Flex>
    </Flex>
  );
};

export default Consignee;
