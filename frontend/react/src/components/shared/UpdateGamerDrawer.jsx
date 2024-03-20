import {
    Button,
    Drawer, DrawerBody,
    DrawerCloseButton,
    DrawerContent,
    DrawerFooter, DrawerHeader,
    DrawerOverlay,
    useDisclosure
} from '@chakra-ui/react';
import UpdateGamerForm from "./UpdateGamerForm.jsx";

const CloseIcon = () => "x";
const UpdateIcon = () => "🔼"

const UpdateGamerDrawer = ({fetchGamers, initialValues, gamerId} ) => {
    const { isOpen, onOpen, onClose } = useDisclosure()
    return <>
        <Button colorScheme='blue'
                leftIcon={<UpdateIcon/>}
                bg={'gray.400'}
                color={'white'}
                rounded={'full'}
                _hover={{
                    transform: 'translateY(-2px)',
                    boxShadow: 'lg'
                }}
                onClick={onOpen}>

            Update Gamer
        </Button>

        <Drawer isOpen={isOpen} onClose={onClose} size={"xl"}>
            <DrawerOverlay />
            <DrawerContent>
                <DrawerCloseButton />
                <DrawerHeader>Update gamer</DrawerHeader>

                <DrawerBody>
                    <UpdateGamerForm
                        fetchGamers = {fetchGamers}
                        initialValues={initialValues}
                        gamerId={gamerId}
                    />
                </DrawerBody>

                <DrawerFooter>
                    <Button
                        leftIcon={<CloseIcon/>}
                        colorScheme={"linkedin"}
                        onClick={onClose}
                    >Close</Button>
                </DrawerFooter>
            </DrawerContent>
        </Drawer>
    </>
}

export default UpdateGamerDrawer;

