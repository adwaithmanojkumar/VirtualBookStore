import React, { useRef, useState } from 'react'
import AliceCarousel from 'react-alice-carousel';
import ArrowBackIosIcon from '@mui/icons-material/ArrowBackIos';
import { Button } from '@mui/material';
import HomeSectionPage from './HomeSectionPage';

const HomeSectionCarousel = ({ data }) => {
    const [activeIndex, setActiveIndex] = useState(0)
    const carouselRef = useRef(null)

    const responsive = {
        0: { items: 1 },
        720: { items: 2 },
        1024: { items: 5 },
    };

    const slidePrev = () => {
        if(activeIndex>0) {
            const newIndex = activeIndex-1
            setActiveIndex(newIndex)
            carouselRef.current.slideTo(newIndex)
        }
    }

    const slideNext = () => {
        if(activeIndex<items.length-1) {
            const newIndex = activeIndex+1
            setActiveIndex(newIndex)
            carouselRef.current.slideTo(newIndex)
        }
    }

    const items = data.slice(0, 10).map((item) => <HomeSectionPage product={item} />)

    return (
        <div className=' border'>
            <div className='relative p-5 '>
                <AliceCarousel
                    items={items}
                    mouseTracking
                    disableButtonsControls
                    responsive={responsive}
                    disableDotsControls
                    activeIndex={activeIndex}
                    ref={carouselRef}
                />
                {activeIndex < items.length - 5 && (<Button onClick={slideNext} variant='contained' className='z-50'
                    sx={{
                        position: "absolute", top: "8rem", right: "0rem",
                        transform: "translateX(50%) rotate(90deg)", bgcolor: "white",
                    }} aria-label="next">
                    <ArrowBackIosIcon sx={{ transform: "rotate(90deg)", color: "black" }} />
                </Button>)}
                {activeIndex > 0 && (<Button variant='contained' className='z-50'
                    onClick={slidePrev}
                    sx={{
                        position: "absolute", top: "8rem", left: "0rem",
                        transform: "translateX(50%) rotate(-90deg)", bgcolor: "white"
                    }} aria-label="previous">
                    <ArrowBackIosIcon sx={{ transform: "rotate(90deg)", color: "black" }} />
                </Button>)}
            </div>
        </div>
    )
}

export default HomeSectionCarousel