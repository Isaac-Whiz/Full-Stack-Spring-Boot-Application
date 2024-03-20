import {
    Button,
    Drawer, DrawerBody,
    DrawerCloseButton,
    DrawerContent,
    DrawerFooter, DrawerHeader,
    DrawerOverlay,
    useDisclosure
} from '@chakra-ui/react';
import CreateGamerForm from "./CreateGamerForm.jsx";

const AddIcon = () => "+";
const CloseIcon = () => "x";

const CreateGamerDrawer = ({fetchGamers} ) => {
    const { isOpen, onOpen, onClose } = useDisclosure()
    return <>
        <Button
        leftIcon={<AddIcon/>}
        backgroundColor={'green.400'}
        onClick={onOpen}
        >
            Create gamer
        </Button>

        <Drawer isOpen={isOpen} onClose={onClose} size={"xl"}>
            <DrawerOverlay />
            <DrawerContent>
                <DrawerCloseButton />
                <DrawerHeader>Create new gamer</DrawerHeader>

                <DrawerBody>
                    <CreateGamerForm
                    fetchGamers = {fetchGamers}
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

export default CreateGamerDrawer;

