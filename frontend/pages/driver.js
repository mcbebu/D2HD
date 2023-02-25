import { Flex, ListItem, ListIcon, Button, List, Text } from "@chakra-ui/react";
import { useState } from 'react';
import { MdCheckCircle, MdCheckCircleOutline } from "react-icons/md";
import { RxCrossCircled } from "react-icons/rx";
import React from "react";
import dynamic from "next/dynamic";
const Navbar = dynamic(() => import("../client/Navbar"));

const consigneeDetails = [
  { address: 'tampines blk 0', is_completed: false },
  { address: 'tampines blk 1', is_completed: false },
  { address: 'tampines blk 2', is_completed: false },
  { address: 'tampines blk 3', is_completed: false },
  { address: 'tampines blk 4', is_completed: false },
  { address: 'tampines blk 5', is_completed: false },
];

const Driver = () => {
  const [ consignees, setConsignees ] = useState(consigneeDetails);

  const handleAccepted = (index) => {
    const updatedConsignees = [ ...consignees ];
    updatedConsignees[ index ].is_completed = true;
    setConsignees(updatedConsignees);
  };

  const handleRejected = (index) => {
    const updatedConsignees = [ ...consignees ];
    updatedConsignees[ index ].is_rejected = true;
    setConsignees(updatedConsignees);
  };

  return (
    <Flex minWidth="100%"
      direction="column">
      <Navbar />
      <Flex className="Driver List" minWidth="100%" direction="column" alignSelf='center'>
        <List spacing={3}>
          {consigneeDetails.slice(0,5).map((consignee, index) => (
            <ListItem key={index}>
              <ListIcon
              as={consignee.is_completed ? MdCheckCircle : consignee.is_rejected ? RxCrossCircled : MdCheckCircleOutline}
                color={consignee.is_completed ? 'green.500' : (consignee.is_rejected  ? 'red.500' : 'gray.500')}
                boxSize={10}
              />
              {consignee.address}
              <Button
                isDisabled={consignee.is_rejected || consignee.is_completed}
                onClick={() => handleAccepted(index)}>
                {consignee.is_completed ? "Accepted" : "Accept"}
              </Button>
              <Button
                isDisabled={consignee.is_completed || consignee.is_rejected}
                onClick={() => handleRejected(index)}>
                {consignee.is_rejected ? "Rejected" : "Reject"}
              </Button>
            </ListItem>
          ))}
        </List>
      </Flex>
    </Flex >
  );
};
export default Driver;
