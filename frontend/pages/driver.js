import { Flex, ListItem, ListIcon, Button, List } from "@chakra-ui/react";
import { useState } from 'react';
import { MdCheckCircle, MdCheckCircleOutline } from "react-icons/md";
import React from "react";

const consigneeDetails = [
  { address: "tampines blk 1", is_completed: "false" },
  { address: "tampines blk 2", is_completed: "false" },
  { address: "tampines blk 3", is_completed: "false" },
];


const Driver = () => {
  // const handleDelivery = () => {
  //   onDelivery();
  // };
  const [ isParcelDelivered, setParcelDelivered ] = useState(false);

  return (
    <Flex alignContent='center'>
      <List spacing={3}>
        <ListItem>
          <ListIcon as={false ? MdCheckCircle : MdCheckCircleOutline} color='green.500' />
          Package 1
        </ListItem>
      </List>
      <Button
        onClick={() =>
          setParcelDelivered((is_completed) => !is_completed)
        }>
      </Button>
    </Flex>
  );
};
export default Driver;
