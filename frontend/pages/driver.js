import {
  Flex,
  ListItem,
  ListIcon,
  Button,
  List,
  Text,
  Heading,
} from "@chakra-ui/react";
import dynamic from "next/dynamic";
import { MdReorder } from "react-icons/md";
import { React, useState, useEffect } from "react";
const Navbar = dynamic(() => import("../driver/Navbar"));
const MARGIN = "8vh";
import DeliveryService from "../api/delivery";
export let tempconsigneeList = [];
const Driver = () => {
  const [consigneeList, setConsigneeList] = useState([]);
  const [refresh, setRefresh] = useState(false);

  useEffect(() => {
    DeliveryService.getWayPointList().then((res) => {
      setConsigneeList(res.data);
      tempconsigneeList = consigneeList;
    });
  }, []);
  const first = consigneeList[0];
  return (
    <Flex className="Layout Parent" id="top" minWidth="100%" direction="column">
      <Flex width="100%" flexDir="column" className="Content Parent">
        <Navbar />
        {consigneeList.length == 0 ? (
          <Flex className="Content Wrapper" direction="column" px="150px">
            <Flex marginTop={MARGIN} justifyContent="center">
              <Heading
                color="#FFF"
                p="20px"
                fontSize="2.5rem"
                textAlign="center"
              >
                Amazing job! No more deliveries remaining. See you tomorrow 😉
              </Heading>
            </Flex>
          </Flex>
        ) : (
          <Flex className="Content Wrapper" direction="column" px="150px">
            <Flex marginTop={MARGIN} justifyContent="center">
              <Heading color="#C31533" p="20px" fontSize="2.5rem">
                Current deliveries:
              </Heading>
            </Flex>
            <Flex
              background="#fff"
              w="450px"
              borderRadius="20px"
              flexDir="column"
              className="content"
              alignSelf="center"
              direction="column"
            >
              <Flex flexDir="column" color="#000" p="25px">
                <Heading fontSize="1.5rem">{first?.consigneeName}</Heading>
                <Text>{first?.consigneeAddress}</Text>
              </Flex>
              <Flex justify="center" marginBottom="25px">
                <Flex>
                  <Button
                    colorScheme="teal"
                    onClick={() => {
                      DeliveryService.updateWayPointList(consigneeList).then(
                        (result) => {
                          setConsigneeList(result.data);
                        }
                      );
                      DeliveryService.clusterUpdate();
                      setRefresh(true);
                    }}
                  >
                    Completed
                  </Button>
                </Flex>
                <Flex px="20px">
                  <Button
                    colorScheme="red"
                    onClick={() => {
                      DeliveryService.updateWayPointList(consigneeList).then(
                        (result) => {
                          setConsigneeList(result.data);
                        }
                      );
                      DeliveryService.clusterUpdate();
                      setRefresh(true);
                    }}
                  >
                    Failed
                  </Button>
                </Flex>
              </Flex>
            </Flex>
            <Flex
              className="Driver List"
              direction="column"
              alignItems="centers"
              p="20px"
            >
              {consigneeList.slice(1, 5).map((consignee, index) => (
                <Flex
                  key={index}
                  alignItems="center"
                  w="300px"
                  justifySelf="center"
                  alignSelf="center"
                >
                  <Flex>
                    <MdReorder />
                  </Flex>
                  <Flex direction="column" px="20px">
                    <Text fontSize="20px" fontWeight="bold">
                      {consignee?.consigneeName}
                    </Text>
                    <Text fontSize="15px">{consignee?.consigneeAddress}</Text>
                  </Flex>
                </Flex>
              ))}
            </Flex>
          </Flex>
        )}
      </Flex>
    </Flex>
  );
};
export default Driver;
