/*
 * Copyright 2024 Vitaliy Zarubin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import './App.css';
import * as React from 'react';
import dayjs from "dayjs";
import shared from "shared";
import { useEffect } from "react";
import { 
  Container, 
  Stack, 
  CircularProgress,
  Box,
} from "@mui/material";
import MyAppBar from "./MyAppBar";
import CardItem from "./CardItem";

/**
 * Ktor client
 */
const HttpClient = shared.my.company.name.ServiceRequestReact


export default function App() {

  const [list, setList] = React.useState([]);

  useEffect(() => {
    const fetchData = async () => {
      setList(await HttpClient.get.repos());
    }
    fetchData().catch(console.error);
  }, []);

  const items = []

  console.log(HttpClient.get)

  list.forEach((item) => {
    items.push((
      <CardItem
        key={`item-${item.id}`}
        name={item.name}
        date={dayjs(item.createdAt).toDate()}
      />
    ));
  })

  return (
    <Box sx={{
      background: '#ecf7f8'
    }}>
      <Container>
        <MyAppBar/>
        {list.length === 0 ? (
          <Box
            display="flex"
            justifyContent="center"
            alignItems="center"
            minHeight="100vh"
          >
            <CircularProgress />
          </Box>
        ) : (
          <Stack
            spacing={2}
            sx={{ 
              pt: 2, 
              pb: 2 
            }}
          >
            {items}
          </Stack>
        )}
      </Container>
    </Box>
  );
}
