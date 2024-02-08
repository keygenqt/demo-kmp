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
import {
  Typography, 
  Box,
  Toolbar,
  AppBar
} from "@mui/material";

export default function MyAppBar(props) {
    return (
      <Box sx={{ 
          flexGrow: 1,
          overflow: 'hidden',
          borderBottomLeftRadius: 10,
          borderBottomRightRadius: 10
        }}
      >
        <AppBar position="static">
          <Toolbar>
            <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
              Demo
            </Typography>
          </Toolbar>
        </AppBar>
      </Box>
    );
}
