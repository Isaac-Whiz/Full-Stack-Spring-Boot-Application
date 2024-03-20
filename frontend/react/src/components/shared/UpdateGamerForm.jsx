import { Formik, Form, useField } from 'formik';
import * as Yup from 'yup';
import {Alert, AlertIcon, Box, Button, FormLabel, Input, Select, Stack} from "@chakra-ui/react";
import {updateGamer} from "../../services/client.js";
import {failureNotification, successNotification} from "../../services/Notification.js";
const MyTextInput = ({ label, ...props }) => {
    const [field, meta] = useField(props);
    return (
        <Box>
            <FormLabel htmlFor={props.id || props.name}>{label}</FormLabel>
            <Input className="text-input" {...field} {...props} />
            {meta.touched && meta.error ? (
                <Alert className="error" status={"error"} mt={2}>
                    <AlertIcon/>
                    {meta.error}</Alert>
            ) : null}
        </Box>
    );
};


// And now we can use these
const UpdateGamerForm = ( {fetchGamers, initialValues, gamerId}) => {
    return (
        <>
            <Formik
                initialValues={initialValues}
                validationSchema={Yup.object({
                    name: Yup.string()
                        .max(15, 'Must be 15 characters or less')
                        .required('Required'),
                    email: Yup.string()
                        .email('Invalid email address')
                        .required('Required'),
                    age: Yup.number()
                        .min(16, "Must be at least 16 years old.")
                        .max(200, "Must be at most 200 years old.")
                        .required('Required'),
                })}
                onSubmit={(updatedGamer, { setSubmitting }) => {
                    setSubmitting(true);
                    updateGamer(gamerId, updatedGamer).then(res => {
                        successNotification("Success", `${updatedGamer.name} updated successfully.`);
                        fetchGamers();
                    }).catch(err => {
                        failureNotification(err.code, err.response.data.message);
                    }).finally(() => {
                        setSubmitting(false);
                    })
                }}>

                {({isValid, isSubmitting}) => ( <Form>
                    <Stack spacing={"20px"}>
                        <MyTextInput
                            label="Name"
                            name="name"
                            type="text"
                            placeholder="Whiz"
                        />
                        <MyTextInput
                            label="Email Address"
                            name="email"
                            type="email"
                            placeholder="whiz@gmail.com"
                        />
                        <MyTextInput
                            label="Age"
                            name="age"
                            type="number"
                            placeholder="30"
                        />
                        <Button disabled={ !isValid || isSubmitting } type="submit">Submit</Button>
                    </Stack>
                </Form>)}
            </Formik>
        </>
    );
};

export default UpdateGamerForm;