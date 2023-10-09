import { createSlice } from "@reduxjs/toolkit";

export const dashSlice = createSlice({
  name: "dash",
  initialState: {
    name: false,
  },
  reducers: {
    setName(state, action) {
      state.name = action.payload;
    },
  },
});

export const { setName } = dashSlice.actions;

export default dashSlice.reducer;
