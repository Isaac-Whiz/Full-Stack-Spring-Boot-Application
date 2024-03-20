import {Wrap, WrapItem, Spinner, Text} from '@chakra-ui/react'
import SidebarWithHeader from "./components/shared/sideBar.jsx";
import {useEffect, useState} from "react";
import {getGamers} from "./services/client.js";
import CardWithImage from "./components/Card.jsx";
import CreateGamerDrawer from "./components/shared/CreateGamerDrawer.jsx";


const App = () => {

    const [gamers, setGamers] = useState([]);
    const [loading, setLoading] = useState(false);

    const fetchGamers = () => {
        setLoading(true);
        getGamers().then(res => {
            setGamers(res.data);
        }).catch(err => {
            console.log(err)
        }).finally(() => {
            setLoading(false);
        })
    };

    useEffect(() => {
        fetchGamers();
    }, [])

    if (loading) {
        return (
            <SidebarWithHeader>
                <Spinner
                    thickness='4px'
                    speed='0.65s'
                    emptyColor='gray.200'
                    color='blue.500'
                    size='xl'
                />
            </SidebarWithHeader>
        )
    }

    if (gamers.length <= 0) {
        return (
            <SidebarWithHeader>
                <CreateGamerDrawer
                    fetchGamers={fetchGamers}
                />
                <Text marginTop={6}>No gamers found 😢</Text>
            </SidebarWithHeader>
        )
    }

    return (
        <SidebarWithHeader>
            <CreateGamerDrawer
            fetchGamers={fetchGamers}
            />
            <Wrap justify={"center"} spacing={"30px"}>
                    {gamers.map((gamer, index) => (
                        <WrapItem key={index}>
                            <CardWithImage
                                {...gamer}
                                randomNumber={index}
                                fetchGamers={fetchGamers}
                            />
                        </WrapItem>
                    ))}
            </Wrap>
        </SidebarWithHeader>
    )
}

export default App;