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
  Card, 
  CardActionArea, 
  CardHeader, 
  Stack, 
  Typography, 
} from "@mui/material";

export default function CardItem(props) {

    const {
      name,
      date,
    } = props
  
    return (
      <Card sx={{ width: '100%' }}>
          <CardHeader
            sx={{ alignItems: 'flex-start' }}
            title={(
              <Typography 
                sx={{ fontWeight: 'bold' }} 
                variant={'body1'} 
                color={'text.primary'}
              >
                {name}
              </Typography>
            )}
            subheader={(
              <Stack spacing={0}>
                <Typography 
                  variant={'caption'} 
                  color={'text.secondary'}
                >
                  {new Intl
                    .DateTimeFormat(date, {
                      year: 'numeric',
                      month: 'long',
                      day: '2-digit',
                    })
                    .format(date)}
                </Typography>
              </Stack>
            )}
          />
      </Card>
    );
}
