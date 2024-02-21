import axios, { Axios } from "axios";

export const getGamers = async () => {
    try {
        return await axios.get(`${import.meta.env.VITE_API_BASE_URL}/api/v1/gamers`);
    } catch (e) {
        throw e;
    }
}