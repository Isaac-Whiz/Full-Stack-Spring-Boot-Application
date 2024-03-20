import axios, { Axios } from "axios";

export const getGamers = async () => {
    try {
        return await axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/v1/gamers`);
    } catch (e) {
        throw e;
    }
}

export const saveGamer = async (gamer) => {
    try {
        return await axios.post(
            `${import.meta.env.VITE_API_BASE_URL}/api/v1/gamer`,
            gamer
        );
    } catch (e) {
        throw e;
    }
}


export const deleteGamer = async (id) => {
    try {
        return await axios.delete(
            `${import.meta.env.VITE_API_BASE_URL}/api/v1/gamers/deleteById/${id}`,
        );
    } catch (e) {
        throw e;
    }
}

export const updateGamer = async (id, update) => {
    try {
        return await axios.put(
            `${import.meta.env.VITE_API_BASE_URL}/api/v1/gamers/update/${id}`,
            update
        );
    } catch (e) {
        throw e;
    }
}