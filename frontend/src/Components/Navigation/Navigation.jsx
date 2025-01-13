import { Disclosure, DisclosureButton, DisclosurePanel, Menu, MenuButton, MenuItem, MenuItems } from '@headlessui/react'
import { Bars3Icon, XMarkIcon } from '@heroicons/react/24/outline'
import { Avatar, Button } from '@mui/material'
import { deepOrange } from '@mui/material/colors'
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import { useLocation, useNavigate } from 'react-router-dom';
import { useEffect, useState } from 'react';
import AuthModal from '../../Auth/AuthModal';
import { useDispatch, useSelector } from 'react-redux';
import { getUser, logout } from '../../State/Auth/Action';
import store from '../../State/store';

const navigation = [
  { name: 'Home', href: '/', current: true },
  { name: 'Books', href: '/books', current: false },
  { name: 'Add', href: '/books/add-book', current: false },
]

function classNames(...classes) {
  return classes.filter(Boolean).join(' ')
}

export default function Navigation() {
  const navigate = useNavigate()
  const [open, setOpen] = useState(false);
  const [openAuthModal, setOpenAuthModal] = useState(false)
  const [anchorEl, setAnchorEl] = useState(null);
  const openUserMenu = Boolean(anchorEl)
  const { auth } = useSelector(store => store)
  const location = useLocation()
  const dispatch = useDispatch()
  const jwt = localStorage.getItem("jwt")

  const handleUserClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleCloseUserMenu = () => {
    setAnchorEl(null);
  };

  const handleMyOrderClick = () => {
    navigate(`/account/order`)
  }

  const handleCart = () => {
    navigate("/cart")
  }

  const handleOpen = () => {
    setOpenAuthModal(true);
  }

  const handleClose = () => {
    setOpenAuthModal(false);
    navigate("/")
  }

  useEffect(() => {
    if (jwt) {
      dispatch(getUser(jwt))
    }
  }, [jwt, auth.jwt])

  useEffect(() => {
    if (auth.user) {
      handleClose()
    }

    if (location.pathname === "/login" || location.pathname === "/register") {
      navigate(-1)
    }
  }, [auth.user])

  const handleLogOut = () => {
    dispatch(logout())
    handleCloseUserMenu()
    console.log(auth)
  }

  return (
    <Disclosure as="nav" className="bg-gray-800">
      <div className="mx-auto max-w-7xl px-2 sm:px-6 lg:px-8">
        <div className="relative flex h-16 items-center justify-between">
          <div className="absolute inset-y-0 left-0 flex items-center sm:hidden">
            {/* Mobile menu button*/}
            <DisclosureButton className="group relative inline-flex items-center justify-center rounded-md p-2 text-gray-400 hover:bg-gray-700 hover:text-white focus:outline-none focus:ring-2 focus:ring-inset focus:ring-white">
              <span className="absolute -inset-0.5" />
              <span className="sr-only">Open main menu</span>
              <Bars3Icon aria-hidden="true" className="block h-6 w-6 group-data-[open]:hidden" />
              <XMarkIcon aria-hidden="true" className="hidden h-6 w-6 group-data-[open]:block" />
            </DisclosureButton>
          </div>
          <div className="flex flex-1 items-center justify-center sm:items-stretch sm:justify-start">
            <div className="flex flex-shrink-0 items-center">
              <img
                alt="Your Company"
                src="https://tailwindui.com/img/logos/mark.svg?color=indigo&shade=500"
                className="h-8 w-auto"
              />
            </div>
            <div className="hidden sm:ml-6 sm:block">
              <div className="flex space-x-4">
                {navigation.map((item) => (
                  <a
                    key={item.name}
                    href={item.href}
                    aria-current={item.current ? 'page' : undefined}
                    className={classNames(
                      item.current ? 'bg-gray-900 text-white' : 'text-gray-300 hover:bg-gray-700 hover:text-white',
                      'rounded-md px-3 py-2 text-sm font-medium',
                    )}
                  >
                    {item.name}
                  </a>
                ))}
              </div>
            </div>
          </div>

          <div className="absolute inset-y-0 right-0 flex items-center pr-2 sm:static sm:inset-auto sm:ml-6 sm:pr-0">
            {/* Profile dropdown */}
            {auth.user ? (
              <Menu as="div" className="relative ml-3">
                <div>
                  <MenuButton className="relative flex rounded-full bg-gray-800 text-sm focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800">
                    <span className="absolute -inset-1.5" />
                    <span className="sr-only">Open user menu</span>
                    <Avatar onClick={(event) => handleUserClick(event)} sx={{ bgcolor: deepOrange[500] }}>{auth.user.firstName[0].toUpperCase()}</Avatar>
                  </MenuButton>
                </div>
                <MenuItems
                  transition
                  className="absolute right-0 z-10 mt-2 w-48 origin-top-right rounded-md bg-white py-1 shadow-lg ring-1 ring-black ring-opacity-5 transition focus:outline-none data-[closed]:scale-95 data-[closed]:transform data-[closed]:opacity-0 data-[enter]:duration-100 data-[leave]:duration-75 data-[enter]:ease-out data-[leave]:ease-in"
                  id="basic-menu"
                  anchorEl={anchorEl}
                  open={openUserMenu}
                  onClose={handleCloseUserMenu}
                  MenuListProps={{
                    "aria-labelledby": "basic-button",
                  }}
                >
                  <MenuItem onClick={handleCloseUserMenu}>
                    <a className="block px-4 py-2 text-sm text-gray-700 data-[focus]:bg-gray-100">
                      Your Profile
                    </a>
                  </MenuItem>
                  <MenuItem aria-controls={open ? "basic-menu" : undefined}
                    aria-haspopup="true"
                    aria-expanded={open ? "true" : undefined}
                    onClick={handleMyOrderClick}>
                    <a className="block px-4 py-2 text-sm text-gray-700 data-[focus]:bg-gray-100">
                      My Order
                    </a>
                  </MenuItem>
                  <MenuItem onClick={handleLogOut}>
                    <a className="block px-4 py-2 text-sm text-gray-700 data-[focus]:bg-gray-100">
                      Sign out
                    </a>
                  </MenuItem>
                </MenuItems>
              </Menu>
            ) : (
              <Button
                onClick={handleOpen}
                sx={{ color: '#e6ede4', fontWeight: '500' }}
                className="text-sm font-semibold hover:text-cyan-200"
              >
                Signin
              </Button>
            )}

            <button
              onClick={() => handleCart()}
              type="button"
              className="relative m-3 rounded-full bg-gray-800 p-1 text-gray-400 hover:text-white focus:outline-none focus:ring-2 focus:ring-white focus:ring-offset-2 focus:ring-offset-gray-800"
            >
              <span className="absolute -inset-1.5" />
              <span className="sr-only">Shopping cart</span>
              <ShoppingCartIcon aria-hidden="true" className="h-6 w-6" />
            </button>
          </div>
        </div>
      </div>

      <DisclosurePanel className="sm:hidden">
        <div className="space-y-1 px-2 pb-3 pt-2">
          {navigation.map((item) => (
            <DisclosureButton
              key={item.name}
              as="a"
              href={item.href}
              aria-current={item.current ? 'page' : undefined}
              className={classNames(
                item.current ? 'bg-gray-900 text-white' : 'text-gray-300 hover:bg-gray-700 hover:text-white',
                'block rounded-md px-3 py-2 text-base font-medium',
              )}
            >
              {item.name}
            </DisclosureButton>
          ))}
        </div>
      </DisclosurePanel>
      <AuthModal handleClose={handleClose} open={openAuthModal} />
    </Disclosure>
  )
}
