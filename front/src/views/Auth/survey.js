// Chakra imports
import {
    Box,
    Button,
    Flex,
    FormControl,
    FormLabel,
    HStack,
    Icon,
    Input,
    Link,
    Switch,
    Text,
    useColorModeValue,
  } from "@chakra-ui/react";
  // Assets
  import BgSignUp from "assets/img/BgSignUp.png";
  import React, { useState } from "react";
  import { FaApple, FaFacebook, FaGoogle } from "react-icons/fa";
  import { useAsync } from "react-async"
  import { createStore } from 'redux';
  import axios from 'axios';
  
  function survey() {
    const titleColor = useColorModeValue("teal.300", "teal.200");
    const textColor = useColorModeValue("gray.700", "white");
    const bgColor = useColorModeValue("white", "gray.700");
    const bgIcons = useColorModeValue("teal.200", "rgba(255, 255, 255, 0.5)");

    const [result, setResult] = useState([]);

    const getSurvey = () =>{
        axios({
            method: "get",
            url: "http://localhost:8181/getsurvey",
          })
          .then((res) => {
            window.alert(res.data.result);
            return res;
          })
          .catch((error) => {
            console.log(error);
          });
    }

    const getSurveyResult = () => { 
      axios({
        method: "post",
        url: "http://localhost:8181/getsurveyresult",
        data: {
          data: result
        },
      })
        .then((res) => {
          window.alert(res.data.result);
        })
        .catch((error) => {
          console.log(error);
        });
    };

    const surveyList = ["첫번째 질문", "두번째 질문", "세번째 질문", "네번째 질문", "다섯번째 질문"]
  
    return (
      <Flex
        direction='column'
        alignSelf='center'
        justifySelf='center'
        overflow='hidden'>
        <Box
          position='absolute'
          minH={{ base: "70vh", md: "50vh" }}
          w={{ md: "calc(100vw - 50px)" }}
          borderRadius={{ md: "15px" }}
          left='0'
          right='0'
          bgRepeat='no-repeat'
          overflow='hidden'
          zIndex='-1'
          top='0'
          bgImage={BgSignUp}
          bgSize='cover'
          mx={{ md: "auto" }}
          mt={{ md: "14px" }}></Box>
        <Flex
          direction='column'
          textAlign='center'
          justifyContent='center'
          align='center'
          mt='6.5rem'
          mb='30px'>
          <Text fontSize='4xl' color='white' fontWeight='bold'>
            나의 성향 분석하기
          </Text>
          <Text
            fontSize='md'
            color='white'
            fontWeight='normal'
            mt='10px'
            mb='26px'
            w={{ base: "90%", sm: "60%", lg: "40%", xl: "30%" }}>
            나와 잘 맞는 반려동물을 알아보세요!
          </Text>
        </Flex>
        <Flex alignItems='center' justifyContent='center' mb='60px' mt='20px'>
          <Flex
            direction='column'
            w='445px'
            background='transparent'
            borderRadius='15px'
            p='40px'
            mx={{ base: "100px" }}
            bg={bgColor}
            boxShadow='0 20px 27px 0 rgb(0 0 0 / 5%)'>
            {surveyList.map(function(i){

              const [radio, setRadio] = useState("");

              const changeRadio = (e) => {
                setRadio(e.target.value);
                result[surveyList.indexOf(i)] = e.target.value
                console.log("실행")
                console.log(result)
              };
                
              return(
                <div> 
                  <div>
                    <Text
                      fontSize='lg'
                      color='gray.400'
                      fontWeight='bold'
                      textAlign='center'
                      mb='22px'>
                      {i}
                    </Text>
                  </div>
                
                  <div>
                    <form>
                      <div className="radio">
                        <label>
                          <input
                            type="radio"
                            value={1}
                            name={1}
                            checked={radio === "1" ? true : false}
                            onChange={changeRadio}
                          />
                          1번
                        </label>
                      </div>
                      <div className="radio">
                        <label>
                          <input
                            type="radio"
                            value={2}
                            name={2}
                            checked={radio === "2" ? true : false}
                            onChange={changeRadio}
                          />
                          2번
                        </label>
                      </div>
                      <div className="radio">
                        <label>
                          <input
                            type="radio"
                            value={3}
                            name={3}
                            checked={radio === "3" ? true : false}
                            onChange={changeRadio}
                          />
                          3번
                        </label>
                      </div>
                      <div className="radio">
                        <label>
                          <input
                            type="radio"
                            value={4}
                            name={4}
                            checked={radio === "4" ? true : false}
                            onChange={changeRadio}
                          />
                          4번
                        </label>
                      </div>
                      <div className="radio">
                        <label>
                          <input
                            type="radio"
                            value={5}
                            name={5}
                            checked={radio === "5" ? true : false}
                            onChange={changeRadio}
                          />
                          5번
                        </label>
                      </div>
                    </form>
                  </div>
              </div>
              )
            })}
            <Flex>
              <Button
                type='submit'
                bg='teal.300'
                fontSize='10px'
                color='white'
                fontWeight='bold'
                w='100%'
                h='45'
                mb='24px'
                marginTop="5%"
                _hover={{
                  bg: "teal.200",
                }}
                _active={{
                  bg: "teal.400",
                }}
                onClick={getSurveyResult}>
                결과보기
              </Button>
            </Flex>
            <Flex
              flexDirection='column'
              justifyContent='center'
              alignItems='center'
              maxW='100%'
              mt='0px'>
            </Flex>
          </Flex>
        </Flex>
      </Flex>
    );
  }
  
export default survey;
  