import React from 'react'
import { book_details } from '../../Data/book_details'
import HomeSectionCarousel from './HomeSectionCarousel'
import MainCarousel from '../MainCarousel/MainCarousel'

const HomeCarousel = () => {
    return (
        <div>
            <div>
                <MainCarousel/>
            </div>
            <div>
                <h2 className='font-medium text-2xl mt-6 block italic text-opacity-70' style={{
                    fontFamily: "'Conv_Cambria Italic',!important",
                    marginBlockEnd: "0.83em",
                    marginInlineStart: "0px",
                    marginInlineEnd: "0px",
                    unicodeBidi: 'isolate',
                    color: "#212529"
                }}>Now Trending</h2>
            </div>
            <div>
                <HomeSectionCarousel data={book_details} />
            </div>
        </div>
    )
}

export default HomeCarousel