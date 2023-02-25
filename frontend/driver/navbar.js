import React, { useState, Component, useRef } from "react";
//import dynamic from "next/dynamic";
import {
  Flex,
  Button,
  Text,
  Heading,
  Link,
  Modal,
  ModalBody,
  ModalFooter,
  ModalOverlay,
  ModalContent,
  ModalHeader,
  ModalCloseButton,
  FormControl,
  FormLabel,
  Input,
  useDisclosure,
  Image,
} from "@chakra-ui/react";

import { useRouter } from "next/router";
const Nav = () => {
  const MenuItem = ({ children, isLast, to = "/", ...rest }) => {
    return (
      <Flex {...rest}>
        <Flex p="1.25rem" variant="ghost" fontSize="lg" fontWeight="500">
          <Text color="#000" display="flex">
            {children}
          </Text>
        </Flex>
      </Flex>
    );
  };
  const router = useRouter();
  return (
    <>
      <Flex
        className="nav"
        align="center"
        w="100%"
        height="13vh"
        position="sticky"
        justify="space-around"
        top="0"
        zIndex="50"
        background="#c42032"
      >
        <Link
          onClick={() => {
            router.push("/");
          }}
        >
          <Flex id="StickyLogo" w="8rem">
            <Image
              h='auto'
              src="https://github.com/mcbebu/D2HD/blob/consignee/frontend/public/driverlogo.png?raw=true"
              alt="ninjavanlogo"
            />
          </Flex>
        </Link>

        <Flex className="NavComponents" align="left" flexBasis="auto">
          <Flex align="center" justify="flex-end" position="relative">
            <Flex p="1.25rem" variant="ghost" fontSize="lg" fontWeight="500">
              <Text color="#FFF" fontWeight="700" display="flex">
                CURRENT TRIPS
              </Text>
            </Flex>
            <MenuItem position="relative" >COMPLETED TRIPS</MenuItem>
            <MenuItem position="relative" >SUPPORT</MenuItem>
            <MenuItem position="relative" >En</MenuItem>
          </Flex>
        </Flex>
      </Flex>
    </>
  );
};

export default Nav;
