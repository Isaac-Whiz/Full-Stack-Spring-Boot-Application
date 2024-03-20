'use client'

import {
    Heading,
    Avatar,
    Box,
    Center,
    Image,
    Flex,
    Text,
    Stack,
    Tag,
    Button,
    useColorModeValue,
    useDisclosure,
    AlertDialog,
    AlertDialogOverlay,
    AlertDialogHeader,
    AlertDialogBody,
    AlertDialogContent,
    AlertDialogFooter,
    Drawer,
    DrawerOverlay,
    DrawerContent,
    DrawerCloseButton,
    DrawerHeader,
    DrawerBody, DrawerFooter,
} from '@chakra-ui/react'
import {useRef} from "react";
import * as PropTypes from "prop-types";
import {failureNotification, successNotification} from "../services/Notification.js";
import {deleteGamer} from "../services/client.js";
import UpdateGamerForm from "./shared/UpdateGamerForm.jsx";
import UpdateGamerDrawer from "./shared/UpdateGamerDrawer.jsx";


AlertDialogHeader.propTypes = {
    fontSize: PropTypes.string,
    fontWeight: PropTypes.string,
    children: PropTypes.node
};
export default function CardWithImage({id, name, email, age, gender, randomNumber, fetchGamers}) {
    const randomGender = gender === "MALE" ? "men" : "women";
    const {isOpen, onOpen, onClose} = useDisclosure()
    const cancelRef = useRef()


    return (
        <Center py={6}>
            <Box
                maxW={'300px'}
                minW={'300px'}
                w={'full'}
                margin={1}
                paddingBottom={3}
                bg={useColorModeValue('white', 'gray.800')}
                boxShadow={'lg'}
                rounded={'md'}
                overflow={'hidden'}>
                <Image
                    h={'120px'}
                    w={'full'}
                    src={
                        'https://images.unsplash.com/photo-1612865547334-09cb8cb455da?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80'
                    }
                    objectFit="cover"
                    alt="#"
                />
                <Flex justify={'center'} mt={-12}>
                    <Avatar
                        size={'xl'}
                        src={
                            `https://randomuser.me/api/portraits/${randomGender}/${randomNumber}.jpg`
                        }
                        css={{
                            border: '2px solid white',
                        }}
                    />
                </Flex>

                <Box p={6}>
                    <Stack spacing={2} align={'center'} mb={5}>
                        <Tag borderRadius={"full"}>{id}</Tag>
                        <Heading fontSize={'2xl'} fontWeight={500} fontFamily={'body'}>
                            {name}
                        </Heading>
                        <Text color={'gray.500'}>{email}</Text>
                        <Text color={'gray.500'}>Age {age} | {gender}</Text>
                    </Stack>
                </Box>
                <Stack direction={"row"} justify={"center"} spacing={6}>
                    <Stack>
                        <UpdateGamerDrawer
                            initialValues={{ name, email, age }}
                        gamerId={id}/>
                    </Stack>
                    <Stack>
                        <Button colorScheme='blue'
                                bg={'red.400'}
                                color={'white'}
                                rounded={'full'}
                                _hover={{
                                    transform: 'translateY(-2px)',
                                    boxShadow: 'lg'
                                }}
                                _focus={{
                                    bg: 'green.500'
                                }}
                                onClick={onOpen}
                        >
                            Delete
                        </Button>


                        <AlertDialog
                            isOpen={isOpen}
                            leastDestructiveRef={cancelRef}
                            onClose={onClose}
                        >
                            <AlertDialogOverlay>
                                <AlertDialogContent>
                                    <AlertDialogHeader fontSize='lg' fontWeight='bold'>
                                        Delete Gamer
                                    </AlertDialogHeader>

                                    <AlertDialogBody>
                                        Surely you want to delete {name} ? You won't be able to undo this.
                                    </AlertDialogBody>

                                    <AlertDialogFooter>
                                        <Button ref={cancelRef} onClick={onClose}>
                                            Cancel
                                        </Button>

                                        <Button colorScheme='red' onClick={() => {
                                            deleteGamer(id).then(
                                                res => {
                                                    successNotification("Deleted", `Gamer ${name} deleted successfully.`);
                                                    fetchGamers();
                                                }
                                            ).catch(err => {
                                                failureNotification(err.code, err.response.data.message)
                                            }).finally(() => onClose());
                                        }}
                                                ml={3}
                                        >
                                            Delete
                                        </Button>

                                    </AlertDialogFooter>
                                </AlertDialogContent>
                            </AlertDialogOverlay>
                        </AlertDialog>

                    </Stack>
                </Stack>
            </Box>
        </Center>
    )
}